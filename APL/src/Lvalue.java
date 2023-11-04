class Lvalue {

    private final AstNode TREE;

    public Lvalue(AstNode ast) {
        this.TREE = ast;
    }

    public AstNode getAst() {
        return this.TREE;
    }

    public double getNumberValue() { return ((NumberNode) this.TREE).getValue(); }

    public boolean getBooleanValue() {
        return ((BoolNode) this.TREE).getValue();
    }

    @Override
    public boolean equals(Object obj) {
        Lvalue oth = (Lvalue) obj;
        return this.TREE.toString().equals(oth.TREE.toString());
    }

    @Override
    public String toString() {
        return this.TREE.toString();
    }
}
