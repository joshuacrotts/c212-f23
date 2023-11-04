class IfNode extends AstNode {

    public IfNode(AstNode predicate, AstNode consequent, AstNode alternative) {
        super(predicate, consequent, alternative);
    }

    /**
     * Interpret an if statement.
     *
     * @param env The environment in which to interpret the if statement.
     * @return The result of the if statement.
     */
    @Override
    public Lvalue eval(Environment env) {
        AstNode pred = this.getPredicate();
        AstNode cons = this.getConsequent();
        AstNode alt = this.getAlternative();

        // Evaluate the predicate, then interpret one way or the other.
        if (pred.eval(env).getBooleanValue()) {
            return cons.eval(env);
        } else {
            return alt.eval(env);
        }
    }

    public AstNode getPredicate() {
        return this.getChildren().get(0);
    }

    public AstNode getConsequent() {
        return this.getChildren().get(1);
    }

    public AstNode getAlternative() {
        return this.getChildren().get(2);
    }

    @Override
    public String toString() {
        return String.format("(if %s %s %s)", this.getPredicate().toString(),
                                              this.getConsequent().toString(),
                                              this.getAlternative().toString());
    }
}
// GameObject g1 = new GameObject(3, 4, 10, 10);

// assertAll (
//   () -> g1.move(2, -5),
//   () -> assertEquals(5, g1.getLocationX()),
//   () -> assertEquals(-1, g1.getLocationY())