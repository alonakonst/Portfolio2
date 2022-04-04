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
       /* Vertex currentv;
        for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            System.out.println("Edges from city: " + currentv.getName());
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currente = currentv.getOutEdges().get(j);
                System.out.println("To " + currente.getToVertex().getName() + " distance " + currente.getWeight());
            }
            System.out.println("");*/

    }

    public void MSTPrims() {

        MinHeap<Vertex> Q = new MinHeap<>();

        if (vertices.size() > 0) {
            vertices.get(0).distance = 0;
            vertices.get(0).prev = vertices.get(0);
        }
        for (int i = 0; i < vertices.size(); i++) {
            Q.Insert(vertices.get(i));
        }

        int MST = 0;

        while (!Q.isEmpty()) {
            Vertex u = Q.extractMin();
            for (int e = 0; e < u.getOutEdges().size(); e++) {
                Vertex v = u.getOutEdges().get(e).getToVertex();

                if ((u.getOutEdges().get(e).getWeight() < v.distance) && !v.visited) {
                    v.distance = u.getOutEdges().get(e).getWeight();
                    //System.out.println(Q.viewMin().distance);
                    int pos = Q.getPosition(v);
                    Q.decreasekey(pos);

                }
            }


            u.visited = true;
            MST = MST + u.getDistance();


        }

        System.out.println("Minimum spanning tree is: " + MST);
        for (int i = 0; i < vertices.size(); i++) {
           System.out.println("Parent: " + vertices.get(i).getName() + " to " + Q.viewMin().distance + " with weight: "    );
        }
    }



        /*for (int i = 0; i < vertices.size(); i++) {
            currentv = vertices.get(i);
            nextv = vertices.get(i++);
            System.out.println("Parent: " + currentv.getName() + " to " + nextv.getName() + " with weight: " );
            for (int j = 0; j < currentv.getOutEdges().size(); j++) {
                Edge currente = currentv.getOutEdges().get(j);
                System.out.println("To " + currente.getToVertex().getName() + " distance " + currente.getWeight());
            }
            System.out.println("");
        }

    }*/
}


    class Vertex implements Comparable<Vertex> {
        private String Name;
        private ArrayList<Edge> outEdges;
        Integer distance = Integer.MAX_VALUE;
        Vertex prev = null;
        public boolean visited = false;


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
        public Integer weight;

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



