package edu.ast;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode implements Evaluable {

    private final List<AstNode> CHILDREN;

    public AstNode(AstNode... nodes) {
        this.CHILDREN = new ArrayList<>(List.of(nodes));
    }

    public List<AstNode> getChildren() {
        return this.CHILDREN;
    }

    public String toString() {
        return toStringHelper(0);
    }

    // Helper method to create string representation
    private String toStringHelper(int level) {
        StringBuilder sb = new StringBuilder();

        // Append indentation
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }

        // Append the current node's value
        sb.append(this.toString()).append("\n");

        // Append the string representation of children
        for (AstNode child : this.CHILDREN) {
            sb.append(child.toStringHelper(level + 1));
        }

        return sb.toString();
    }

}
