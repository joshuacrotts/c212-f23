import java.util.List;

class ApplyNode extends AstNode {

    public ApplyNode(AstNode functionDef, AstNode... operands) {
        super();
        this.getChildren().add(functionDef);
        this.getChildren().addAll(List.of(operands));
    }

    /**
     * Interprets an application node. We evaluate the function and its
     * arguments, then apply the function to the arguments.
     *
     * @param env The environment in which to interpret the application.
     * @return The result of the application interpretation.
     */
    @Override
    public Lvalue eval(Environment env) {
        AstNode func = this.getFunction();
        // Interpret the function and convert it into its AST.
        FuncNode funcVal = (FuncNode) func.eval(env).getAst();
        // Evaluate each argument before applying the function.
        List<AstNode> argVals = this.getArguments().stream()
                                                   .map(n -> n.eval(env).getAst())
                                                   .toList();
        // Extend the environment with the function's parameters and the argument values.
        Environment e1 = env.extend(funcVal.getParameters(), argVals);
        return funcVal.getBody().eval(e1);
    }

    public AstNode getFunction() {
        return this.getChildren().get(0);
    }

    public List<AstNode> getArguments() {
        return this.getChildren().subList(1, this.getChildren().size());
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", this.getFunction().toString(), this.getArguments().toString());
    }
}
