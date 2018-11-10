import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class Node {

    public enum Type {
        CLIENT, ROUTER
    }

    public final Type type;
    public final int id;
    public final List<Edge> edges;

    public Node(Type type, int id) {
        this(type, id, new ArrayList<>());
    }

    public Node(Type type, int id, List<Edge> edges) {
        this.type = requireNonNull(type);
        this.id = id;
        this.edges = requireNonNull(edges);
    }

}