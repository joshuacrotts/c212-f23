class Add implements Expr {

    private Expr e1;
    private Expr e2;

    public Add(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int value() { return this.e1.value() + this.e2.value(); }
}
