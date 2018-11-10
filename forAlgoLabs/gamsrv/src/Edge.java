import static java.util.Objects.requireNonNull;

public class Edge {

    public final Node start;
    public final Node end;
    public final long networkLatency;

    public Edge(Node start, Node end, long networkLatency) {
        this.start = requireNonNull(start);
        this.end = requireNonNull(end);
        this.networkLatency = networkLatency;
    }

}