class Neg implements Expr {

    private Expr e1;

    public Neg(Expr e1) {
        this.e1 = e1;
    }

    @Override
    public int value() { return this.e1.value() * -1; }
}
