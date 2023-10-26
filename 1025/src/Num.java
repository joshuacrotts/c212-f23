class Num implements Expr {

    private int n;

    public Num(int n) { this.n = n; }

    @Override
    public int value() { return this.n; }
}
