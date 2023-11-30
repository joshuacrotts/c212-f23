package edu.ast;

public class VarNode extends AstNode {

    private final String VALUE;

    public VarNode(String v) {
        super();
        this.VALUE = v;
    }

    /**
     * Interpret a variable. We look up the variable in the environment and
     * return the value associated with it.
     *
     * @param env The environment in which to interpret the variable.
     * @return The result of the variable lookup after interpretation.
     */
    @Override
    public Lvalue eval(Environment env) {
        String var = this.getValue();
        AstNode res = env.get(var);
        return res.eval(env);
    }

    public String getValue() {
        return VALUE;
    }

    @Override
    public String toString() {
        return this.VALUE;
    }
}
