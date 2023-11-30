package edu.ast;

public class ProgramNode extends AstNode {

    public ProgramNode(AstNode... nodes) {
        super(nodes);
    }

    /**
     * Interprets a program as a sequence of definitions and expressions.
     *
     * @param env The environment in which to interpret the program.
     * @return a edu.ast.NumberNode of zero representing program success.
     */
    @Override
    public Lvalue eval(Environment env) {
        for (int i = 0; i < this.getChildren().size() - 1; i++) {
            this.getChildren().get(i).eval(env);
        }
        return this.getChildren().get(this.getChildren().size() - 1).eval(env);
    }

    @Override
    public String toString() {
        return String.format("(program %s)", this.getChildren().toString());
    }
}
