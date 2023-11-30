package edu.ast;

public class LetNode extends AstNode {

    private final String VALUE;

    public LetNode(String var, AstNode exp, AstNode body) {
        super(exp, body);
        this.VALUE = var;
    }

    /**
     * Interpret a let statement. A new environment is introduced in which the
     * let body is evaluated.
     *
     * @param env The environment in which to interpret the let binding.
     * @return The result of the let statement.
     */
    @Override
    public Lvalue eval(Environment env) {
        String var = this.getVar();
        AstNode exp = this.getExp();
        AstNode body = this.getBody();

        // Interpret the expression and convert it into its AST.
        AstNode newExp = exp.eval(env).getAst();
        Environment e1 = env.extend(var, newExp);
        return body.eval(e1);
    }

    public String getVar() {
        return this.VALUE;
    }

    public AstNode getExp() {
        return this.getChildren().get(0);
    }

    public AstNode getBody() {
        return this.getChildren().get(1);
    }

    @Override
    public String toString() {
        return String.format("(let ([%s %s]) %s)", this.getVar(), this.getExp(), this.getBody());
    }
}
