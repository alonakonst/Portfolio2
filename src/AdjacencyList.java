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
Vertex predecessor;
       
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
            Vertex v ;
            
            for (int e = 0; e < u.getOutEdges().size(); e++) {
                 v = u.getOutEdges().get(e).getToVertex();


                if ((u.getOutEdges().get(e).getWeight() < v.distance) && !v.visited) {
                   v.setPrev(u);
                    v.distance = u.getOutEdges().get(e).getWeight();//all edges
                    int pos = Q.getPosition(v);
                    Q.decreasekey(pos);

                }

                
                
            }
            MST = MST + u.getDistance(); 
            u.visited = true;

        
            if(u.distance == 0){
                System.out.println(u.getName() + " is the starting point");
                 } else {
                     System.out.println("From " + u.getPrev(u).getName() + " to " + u.getName() +" with ditance " + u.distance +  " km.");
                 }
        
        }
        System.out.println(" ");
        System.out.println("Minimum spanning tree is: " + MST + "km.");
        System.out.println("The total price is: " + MST*1000000 + " kr.");
      
        
    
    }

}


    class Vertex implements Comparable<Vertex> {
        private String Name;
        private ArrayList<Edge> outEdges;
        Integer distance = Integer.MAX_VALUE;
        Vertex prev = null;
        public boolean visited = false;

        public void setPrev(Vertex prev){
            this.prev = prev;
        }

        public Vertex getPrev(Vertex prev){
            return this.prev;
        }

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



