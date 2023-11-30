package edu.parser;

import edu.ast.*;
import edu.lexer.Lexer;
import edu.lexer.Token;
import edu.lexer.TokenType;

import java.util.ArrayList;
import java.util.List;

class Parser {

  private List<Token> tokens;

  private int pos;

  public Parser(List<Token> tokens) {
    this.tokens = tokens;
    this.pos = 0;
  }

  public AstNode parse() {
    return parseExpr();
  }

  public AstNode parseExpr() {
    if (this.pos >= tokens.size()) {
      throw new RuntimeException("Unexpected end of input");
    }

    Token tok = this.tokens.get(this.pos);

    switch (tok.type()) {
      case NUMBER: {
        this.pos++;
        return new NumberNode(Double.parseDouble(tok.data()));
      }
      case SYMBOL: {
        this.pos++;
        return new VarNode(tok.data());
      }
      case OPEN_PAREN: {
          // Move past the '(' token
          this.pos++;
          tok = tokens.get(this.pos);
//          System.out.println("Current tok="+tok);
          if ("if".equals(tok.data())) {
            return parseIfExpression();
          } else if ("let".equals(tok.data())) {
            return parseLetExpression();
          } else if ("lambda".equals(tok.data())) {
            return parseLambdaExpression();
          }

          // Other expressions like lists, etc.
//          this.pos--;
          return parseList();
        }
      default:
        throw new IllegalArgumentException("unknown token " + tok.type());
    }
  }

  private AstNode parseIfExpression() {
    // Move past the if.
    this.pos++;

    AstNode pred = this.parseExpr();
    AstNode cons = this.parseExpr();
    AstNode alte = this.parseExpr();

    // Expect a closing parenthesis.
    if (this.tokens.get(pos).type() != TokenType.CLOSE_PAREN) {
      throw new RuntimeException("expected )");
    }
    this.pos++;
    return new IfNode(pred, cons, alte);
  }

  private AstNode parseLetExpression() {
    // Skip over the let.
    this.pos++;

    // Skip over the two ((
    this.pos += 2;
    String v = this.tokens.get(this.pos).data();
    this.pos++ ;
    AstNode expr = parseExpr();

    // Skip over the closing parentheses.
    this.pos += 2;
    AstNode body = parseExpr();
    // Expect a closing parenthesis.
    if (this.tokens.get(pos).type() != TokenType.CLOSE_PAREN) {
      throw new RuntimeException("expected ) but got " + this.tokens.get(pos).data());
    }
    this.pos++;
    return new LetNode(v, expr, body);
  }

  private AstNode parseLambdaExpression() {
    // Skip over the lambda.
    this.pos++;

    // Skip over the open parenthesis to the formals.
    this.pos++;

    // Grab all formals.
    List<String> formals = new ArrayList<>();
    while (this.tokens.get(this.pos).type() != TokenType.CLOSE_PAREN) {
      formals.add(this.tokens.get(this.pos++).data());
    }


    // Skip over the closing parenthesis.
    this.pos++;
    AstNode body = this.parseExpr();
    // Expect a closing parenthesis.
    if (this.tokens.get(pos).type() != TokenType.CLOSE_PAREN) {
      throw new RuntimeException("expected )");
    }
    this.pos++;
    return new FuncNode(formals, body);
  }

  private AstNode parseList() {
    List<AstNode> elements = new ArrayList<>();

    while (this.pos < tokens.size() && tokens.get(this.pos).type() != TokenType.CLOSE_PAREN) {
//      System.out.println(elements + ", " + this.pos + ", " + tokens.get(this.pos));
      elements.add(parseExpr());
//      this.pos++;
    }

    System.out.println(elements);

    this.pos++; // Skipping the RIGHT_PAREN

    // Check if this list is a function call
    if (!elements.isEmpty() && elements.get(0) instanceof VarNode) {
//      System.out.println("HERE?");
      VarNode functionName = (VarNode) elements.remove(0);
      // If it's a primitive...
      if (PrimNode.isPrim(functionName.getValue())) {
//        System.out.println("It's a prim");
        return new PrimNode(functionName.getValue(), elements);
      } else {
        return new ApplyNode(functionName, elements);
      }
    }

    SExprNode ee = new SExprNode();
    for (AstNode e : elements) {
      ee.getChildren().add(e);
    }
    return ee;
  }

  public static void main(String[] args) {
    AstNode t = new Parser(Lexer.lex("(let ((add1 (lambda (x) (+ x 1)))) (add1 10))")).parse();
    AstNode t2 = new Parser(Lexer.lex("(if (eq? 2 3) 41 42)")).parse();
    System.out.println(t.eval(new Environment()));
    System.out.println(t2.eval(new Environment()));
  }
}
