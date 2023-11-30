package edu.ast;

public class SExprNode extends AstNode {

  public SExprNode() {
    super();
  }

  @Override
  public Lvalue eval(Environment env) {
    throw new UnsupportedOperationException("eval: cannot evaluate an s-expression directly.");
  }

  public String toString() {
    String s = "(";
    for (AstNode t : this.getChildren()) {
      s += t.toString() + " ";
    }
    s = s.trim();
    return s + ")";
  }
}
