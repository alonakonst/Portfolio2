import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyList {
    private ArrayList<Vertex> vertices;

    public AdjacencyList() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public void newEdge(Vertex from, Vertex to, Integer dist) {
        if (!(vertices.contains(from) && vertices.contains(to))) {
            System.out.println("Vertex not found ");
            return;
        }
        Edge newedge = new Edge(from, to, dist);
    }

    public void printGraph() {
        Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            System.out.println("Edges from city: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size(); j++)
            {
                Edge currente = currentv.getOutEdges().get(j);
                System.out.println("To " + currente.getToVertex().getName() + " distance " + currente.getWeight());
            }
            System.out.println("");
        }
    }
   public void MSTPrims() {
        int[] Distance = new int[vertices.size()];
        int[] Predecessor = new int[vertices.size()];
        boolean[] visited = new boolean[vertices.size()];

        MinHeap<Vertex> Q = new MinHeap<>();
        Arrays.fill(Distance, Integer.MAX_VALUE);
        Arrays.fill(Predecessor, 0);
        Arrays.fill(visited, false);

        if (vertices.size() > 0) {
            Distance[0] = 0;
        }
        for (int i = 0; i < vertices.size(); i++) {
            Q.Insert(new Vertex(Integer.toString(i)));
        }

        int MST = 0;
        while (!Q.isEmpty()) {
            Vertex u = Q.extractMin();
            for (int v = 0; v < vertices.size(); v++) {
                if (vertices.size() && (u.getOutEdges().get(v).getWeight() < Distance[v]) && !visited[v]) {
                    Distance[v] = u.getDistance();
                    Predecessor[v] = u.getWeight();

                    System.out.println(Q.viewMin().distance);
                    int pos = Q.getPosition(vertices.get(v));
                    vertices.get(v).distance = u.getDistance();
                    Q.decreasekey(pos);

                }
            }

            visited[u.distance] = true;
            MST = MST + Distance[u.distance];
        }
        System.out.println(MST);

        for(int i = 0; i < vertices.size(); i++){
            System.out.println("Parent: " + Predecessor[i] + " to " + i + " with weight: " + Distance[i]);
        }

    }
}

    class Vertex implements Comparable<Vertex> {
        private String Name;
        private ArrayList<Edge> outEdges;
        Integer distance = Integer.MAX_VALUE;


        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public ArrayList<Edge> getOutEdges() {
            return outEdges;
        }

        public void setOutEdges(ArrayList<Edge> outEdges) {
            this.outEdges = outEdges;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Vertex(String id) {
            this.Name = id;
            outEdges = new ArrayList<>();
        }

        public void addOutEdge(Edge outEdge) {
            outEdges.add(outEdge);
        }


        @Override
        public int compareTo(Vertex o) {
            if (this.distance < o.distance)
                return -1;
            if (this.distance > o.distance)
                return 1;

            return 0;
        }
    }

    class Edge {
        private Vertex fromVertex;
        private Vertex toVertex;
        private Integer weight;

        public Vertex getFromVertex() {
            return fromVertex;
        }

        public void setFromVertex(Vertex fromVertex) {
            this.fromVertex = fromVertex;
        }

        public Vertex getToVertex() {
            return toVertex;
        }

        public void setToVertex(Vertex toVertex) {
            this.toVertex = toVertex;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Edge(Vertex from, Vertex to, Integer cost) {
            fromVertex = from;
            toVertex = to;
            weight = cost;
            from.addOutEdge(this);
        }
    }


