import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Gamsrv {

    private static final String separator = " ";

    public static void main(String[] args) {
        Path serverInput = args.length >= 1 ? Paths.get(args[0]) : Paths.get("gamsrv.in");
        Path serverOutput = args.length >= 2 ? Paths.get(args[1]) : Paths.get("gamsrv.out");

        Graph graph = readGraph(serverInput);

        List<Node> router = graph.getRouter();
        List<Long> maxNetworkLatency = new ArrayList<>(router.size());
        for (Node routerNode : router) {
            Map<Node, Long> NetworkLatency = dijkstraAlgorithm(graph, routerNode.id);

            List<Long> clientNetworkLatency = new ArrayList<>(graph.nodes.size() - router.size());
            for (Map.Entry<Node, Long> networkLatency : NetworkLatency.entrySet()) {
                if (networkLatency.getKey().type == Node.Type.CLIENT) {
                    clientNetworkLatency.add(networkLatency.getValue());
                }
            }

            maxNetworkLatency.add(Collections.max(clientNetworkLatency));
        }

        Long minMaxNetworkLatency = Collections.min(maxNetworkLatency);
        writeResult(serverOutput, minMaxNetworkLatency);
    }

    private static Map<Node, Long> dijkstraAlgorithm(Graph graph, int sourceNodeId) {
        Node sourceNode = graph.nodes.get(sourceNodeId);

        Map<Node, Long> NetworkLatency = new HashMap<>(graph.nodes.size());
        for (Node node : graph.nodes.values()) {
            NetworkLatency.put(node, Long.MAX_VALUE);
        }
        NetworkLatency.put(sourceNode, 0L);

        Comparator<Node> nodeDistanceComparator = Comparator.comparing(NetworkLatency::get);
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(nodeDistanceComparator);
        nodePriorityQueue.add(sourceNode);

        while (!nodePriorityQueue.isEmpty()) {
            Node minNetworkLatencyNode = nodePriorityQueue.remove();

            for (Edge edge : minNetworkLatencyNode.edges) {
                Node neighbourNode = edge.end;
                long alternativeNetworkLatency = NetworkLatency.get(minNetworkLatencyNode) + edge.networkLatency;

                if (alternativeNetworkLatency < NetworkLatency.get(neighbourNode)) {
                    NetworkLatency.put(neighbourNode, alternativeNetworkLatency);
                    nodePriorityQueue.add(neighbourNode);
                }
            }
        }

        return NetworkLatency;
    }

    private static Graph readGraph(Path serverInput) {
        try (BufferedReader serverInputReader = Files.newBufferedReader(serverInput)) {
            String nodeLine = serverInputReader.readLine();
            int nodesCount = Integer.valueOf(nodeLine.split(separator)[0]);

            Map<Integer, Node> nodes = new HashMap<>(nodesCount);

            String clientIdsLine = serverInputReader.readLine();
            for (String idLine : clientIdsLine.split(separator)) {
                int clientId = Integer.parseInt(idLine);
                nodes.put(clientId, new Node(Node.Type.CLIENT, clientId));
            }

            for (String line; (line = serverInputReader.readLine()) != null; ) {
                String[] lineValues = line.split(separator);

                Node start = nodes.computeIfAbsent(Integer.parseInt(lineValues[0]),
                        nodeId -> new Node(Node.Type.ROUTER, nodeId));
                Node end = nodes.computeIfAbsent(Integer.parseInt(lineValues[1]),
                        nodeId -> new Node(Node.Type.ROUTER, nodeId));
                long networkLatency = Long.parseLong(lineValues[2]);

                Edge edge = new Edge(start, end, networkLatency);
                start.edges.add(edge);

                Edge reverseEdge = new Edge(end, start, networkLatency);
                end.edges.add(reverseEdge);
            }
            return new Graph(nodes);
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
    }


    private static void writeResult(Path serverOutput, long result) {
        try {
            Files.write(serverOutput, String.valueOf(result).getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
    }
}