class DefNode extends AstNode {

    private final String VALUE;

    public DefNode(String var, AstNode exp) {
        super(exp);
        this.VALUE = var;
    }

    /**
     * Interprets a definition node. We add the definition to the environment
     * and return a NumberNode of zero to designate that definitions resolve to
     * nothing.
     *
     * @param env The environment in which to interpret the definition.
     * @return a NumberNode of zero representing definition success.
     */
    @Override
    public Lvalue eval(Environment env) {
        env.put(this.getVar(), this.getExp().eval(env).getAst());
        return new Lvalue(new NumberNode(0));
    }

    public String getVar() {
        return this.VALUE;
    }

    public AstNode getExp() {
        return this.getChildren().get(0);
    }

    @Override
    public String toString() {
        return String.format("(define %s %s)", this.getVar(), this.getExp());
    }
}
