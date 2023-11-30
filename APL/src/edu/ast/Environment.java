package edu.ast;

import java.util.HashMap;
import java.util.List;

public final class Environment extends HashMap<String, AstNode> {

    private final Environment PARENT;

    public Environment() {
        this(null);
    }

    public Environment(Environment parent) {
        super();
        this.PARENT = parent;
    }

    /**
     * Extends the current environment with a new binding.
     *
     * @param k identifier to bind.
     * @param v edu.ast.AstNode to bind.
     * @return new edu.ast.Environment containing old bindings and the new binding.
     */
    public Environment extend(String k, AstNode v) {
        Environment e1 = new Environment();
        for (String oldK : this.keySet()) {
            e1.put(oldK, this.get(oldK));
        }
        e1.put(k, v);
        return e1;
    }

    /**
     * Extends the current environment with a list of formals and a list of
     * arguments. The lists must be of the same length.
     *
     * @param formals list of identifiers to bind.
     * @param arguments list of evaluated AstNodes to bind.
     * @return new edu.ast.Environment containing old bindings and the new bindings.
     */
    public Environment extend(List<String> formals, List<AstNode> arguments) {
        Environment e1 = new Environment(this);
        for (int i = 0; i < formals.size(); i++) {
            e1.put(formals.get(i), arguments.get(i));
        }
        return e1;
    }
}
