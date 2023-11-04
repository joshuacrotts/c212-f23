class NumberNode extends AstNode {

    private final double VALUE;

    public NumberNode(String s) {
        super();
        this.VALUE = Double.parseDouble(s);
    }

    public NumberNode(double d) {
        this(String.valueOf(d));
    }

    @Override
    public Lvalue eval(Environment env) {
        return new Lvalue(this);
    }

    public double getValue() {
        return this.VALUE;
    }

    @Override
    public String toString() {
        return String.format("%f", this.VALUE);
    }
}
