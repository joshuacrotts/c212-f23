import java.util.List;

class PrimNode extends AstNode {

    private final String OP;

    public PrimNode(String op, AstNode... operands) {
        super(operands);
        this.OP = op;
    }

    /**
     * Interpret a primitive operation.
     *
     * @param env The environment in which to interpret the operation.
     * @return The result of the primitive operation.
     */
    @Override
    public Lvalue eval(Environment env) {
        String op = this.getOperator();
        // Evaluate each argument before applying the primitive.
        List<Lvalue> operands = this.getOperands().stream()
                                                  .map(n -> n.eval(env))
                                                  .toList();
        // Each primitive operator is handled differently.
        // For basic things like addition and subtraction, we can simply
        // map the values to their unwrapped types and collect the result.
        return new Lvalue(
                switch (op) {
                    case "+" -> new NumberNode(operands.stream()
                            .map(Lvalue::getNumberValue)
                            .reduce(0.0, Double::sum));
                    case "-" -> new NumberNode(primSub(operands));
                    case "*" -> new NumberNode(operands.stream()
                            .map(Lvalue::getNumberValue)
                            .reduce(1.0, (acc, c) -> acc * c));
                    case "eq?" ->
                            new BoolNode(operands.get(0).equals(operands.get(1)));
                    default -> null;
                });
    }

    public String getOperator() {
        return this.OP;
    }

    public List<AstNode> getOperands() {
        return this.getChildren();
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", this.getOperator(), this.getOperands().toString());
    }

    private double primSub(List<Lvalue> operands) {
        double res = operands.get(0).getNumberValue();
        for (int i = 1; i < operands.size(); i++) {
            res -= operands.get(i).getNumberValue();
        }
        return res;
    }
}
