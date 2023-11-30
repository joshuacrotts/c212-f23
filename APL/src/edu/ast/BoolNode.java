package edu.ast;

public class BoolNode extends AstNode {

    private final boolean VALUE;

    public BoolNode(String v) {
        super();
        this.VALUE = Boolean.parseBoolean(v);
    }

    public BoolNode(boolean b) {
        this(String.format("%b", b));
    }

    @Override
    public Lvalue eval(Environment env) {
        return new Lvalue(this);
    }

    public boolean getValue() {
        return VALUE;
    }

    @Override
    public String toString() {
        return String.format("%b", this.VALUE);
    }
}
