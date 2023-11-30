package edu.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Lexer {

  public static List<Token> lex(String input) {
    List<Token> tokenList = new ArrayList<>();
    char[] chars = input.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      switch (c) {
        case '(': {
          tokenList.add(new Token(TokenType.OPEN_PAREN, "("));
          break;
        }
        case ')': {
          tokenList.add(new Token(TokenType.CLOSE_PAREN, ")"));
          break;
        }
        default: {
          if (Character.isWhitespace(c)) {
            continue;
          } else {
            StringBuilder tok = new StringBuilder();
            while (i < chars.length && !Character.isWhitespace(chars[i])  && chars[i] != '(' && chars[i] != ')') {
              tok.append(chars[i]);
              i++;
            }
            i--;
            Token t = new Token(isNumber(tok.toString()) ? TokenType.NUMBER : TokenType.SYMBOL, tok.toString());
            tokenList.add(t);
          }
        }
      }
    }
    return tokenList;
  }

  private static boolean isNumber(String n) {
    try {
      Double.parseDouble(n);
      return true;
    } catch (NumberFormatException ex) {
      return false;
    }
  }

  private static boolean isSymbol(String s) {
    return !isNumber(s);
  }

  public static void main(String[] args) {
    System.out.println(Lexer.lex("(define foo (lambda (x) (+ x 5)))"));
  }
}
