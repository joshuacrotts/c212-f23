import java.util.ArrayList;
import java.util.List;

abstract class AstNode implements Evaluable {

    private final List<AstNode> CHILDREN;

    public AstNode(AstNode... nodes) {
        this.CHILDREN = new ArrayList<>(List.of(nodes));
    }

    public List<AstNode> getChildren() {
        return this.CHILDREN;
    }
}
