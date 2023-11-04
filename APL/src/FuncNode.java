import java.util.List;

class FuncNode extends AstNode {

    private final List<String> PARAMS;

    public FuncNode(List<String> params, AstNode body) {
        super(body);
        this.PARAMS = params;
    }

    /**
     * Interprets a function node.
     *
     * @param env The environment in which to interpret the function.
     * @return The result of the function interpretation.
     */
    public Lvalue eval(Environment env) {
        List<String> params = this.getParameters();
        AstNode body = this.getBody();
        return new Lvalue(new FuncNode(params, body));
    }

    public List<String> getParameters() {
        return this.PARAMS;
    }

    public AstNode getBody() {
        return this.getChildren().get(0);
    }

    @Override
    public String toString() {
        return String.format("(λ %s %s)", this.getParameters().toString(), this.getBody().toString());
    }
}
