import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {

    public final Map<Integer, Node> nodes;

    public Graph() {
        this(new HashMap<>());
    }

    public Graph(Map<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getRouter() {
        List<Node> router = new ArrayList<>(nodes.size());
        for (Node node : nodes.values()) {
            if (node.type == Node.Type.ROUTER) {
                router.add(node);
            }
        }
        return router;
    }


}