package L8;

import java.util.ArrayList;

public class L8Q1 {
    public static void main(String[] args) {
        weightedGraph<String,Integer> graph = new weightedGraph<>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String i : cities)
            graph.addVertex(i);

        System.out.println("The number of vertices in graph: " + graph.getSize());

        System.out.println("Cities and their vertices ");
        for (int i = 0; i < graph.getSize(); i++)
            System.out.print(i + ": " + graph.getVertex(i) + "\t");
        System.out.println();

        System.out.println("Is Melaka in the Graph? " + graph.hadVertex("Melaka"));
        System.out.println("Is Ipoh in the Graph? " + graph.hadVertex("Ipoh"));
        System.out.println();

        System.out.println("Kuching at index:  " + graph.getIndex("Kuching"));
        System.out.println("Ipoh at index:  " + graph.getIndex("Ipoh"));
        System.out.println();

        System.out.println("add edge Kuching - Melaka: " + graph.addEdge("Kuching", "Melaka",2000));
        System.out.println("add edge Langkawi - Penang : " + graph.addEdge("Langkawi", "Penang",2000));
        System.out.println("add edge Melaka - Penang : " + graph.addEdge("Melaka", "Penang",2000));
        System.out.println("add edge Alor Setar - Kuching : " + graph.addEdge("Alor Setar", "Kuching",2000));
        System.out.println("add edge Tawau - Alor Setar : " + graph.addEdge("Tawau", "Alor Setar",2000));
        System.out.println("add edge Kuching - Tawau : " + graph.addEdge("Kuching", "Tawau",2000));
        System.out.println("add edge Langkawi - Ipoh : " + graph.addEdge("Langkawi", "Ipoh",2000));
        System.out.println();

        System.out.println("has edge from Kuching to Melaka?  " + graph.hadEdge("Kuching", "Melaka") );
        System.out.println("has edge from Melaka to Langkawi?  " + graph.hadEdge("Melaka", "Kuching") );
        System.out.println("has edge from Ipoh to Langkawi?  " + graph.hadEdge("Ipoh", "Langkawi") );
        System.out.println();

        System.out.println("In and out degree for Kuching is " + graph.getInDegree("Kuching") + " and " + graph.getOutDegree("Kuching") );
        System.out.println("In and out degree for Penang is " + graph.getInDegree("Penang") + " and " + graph.getOutDegree("Penang") );
        System.out.println("In and out degree for Ipoh is " + graph.getInDegree("Ipoh") + " and " + graph.getOutDegree("Ipoh") );
        System.out.println();

        System.out.println("Neighbours of Kuching : " + graph.getNeighbour("Kuching"));
        System.out.println("\nPrint Edges : " );
        graph.printEdges();
    }
}

class weightedGraph <T extends Comparable<T>, N extends Comparable<N>>{
    private Vertex<T,N> head;
    private int size;

    private static class Vertex<T extends Comparable<T>, N extends Comparable<N>>{
        T vertexInfo;
        int inDegree;
        int outDegree;
        Vertex<T,N> nextVertex;
        Edge<T,N> firstEdge;
        public Vertex(){}
        public Vertex(T vertexInfo,Vertex<T,N> nextVertex){
            this.vertexInfo=vertexInfo;
            inDegree=0;
            outDegree=0;
            this.nextVertex=nextVertex;
            this.firstEdge=null;
        }
    }

    private static class Edge<T extends Comparable<T>, N extends Comparable<N>>{
        Vertex<T,N> toVertex;
        Edge<T,N> nextEdge;
        N weight;
        public Edge(){
            this(null,null,null);
        }
        public Edge(Vertex<T, N> destination, N weight, Edge<T, N> a) {
            this.toVertex = destination;
            this.weight = weight;
            this.nextEdge = a;
        }
    }

    public weightedGraph(){
        this.head=null;
        this.size=0;
    }
    public void clear(){
        this.head=null;
        this.size=0;
    }
    public int getSize() {
        return size;
    }
    public int getInDegree(T t){
        Vertex<T,N> temp=head;
        while(temp!=null){
            if(temp.vertexInfo.compareTo(t)==0){
                return temp.inDegree;
            }
            temp=temp.nextVertex;
        }
        return -1;
    }
    public int getOutDegree(T t){
        Vertex<T,N> temp=head;
        while(temp!=null){
            if(temp.vertexInfo.compareTo(t)==0){
                return temp.outDegree;
            }
            temp=temp.nextVertex;
        }
        return -1;
    }
    public Boolean hadVertex(T t){
        Vertex<T,N> temp=head;
        while (temp!=null){
            if (temp.vertexInfo.compareTo(t)==0){
                return true;
            }
            temp=temp.nextVertex;
        }
        return false;
    }
    public boolean addVertex(T t){
        if (hadVertex(t)==false){
            Vertex<T,N> temp=head;
            Vertex<T,N> newVertex=new Vertex<>(t,null);
            if(head==null) head=newVertex;
            else{
                Vertex<T,N> previous=head;
                while(temp!=null){
                    previous=temp;
                    temp=temp.nextVertex;
                }
                previous.nextVertex=newVertex;
            }
            size++;
            return true;
        }
        else return false;
    }
    public boolean addEdge(T source,T destination, N weight){
        if (!hadVertex(source)||!hadVertex(destination)) return false;
        for(Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if(sourceVertex.vertexInfo.compareTo(source) == 0) {
                for(Vertex<T, N> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex) {
                    if(destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, weight, sourceVertex.firstEdge);
                        sourceVertex.outDegree++;
                        destinationVertex.inDegree++;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public int getIndex(T t){
        Vertex<T, N> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.vertexInfo.compareTo(t) == 0) {
                return index;
            }
            temp = temp.nextVertex;
            index++;
        }
        return -1;
    }
    public ArrayList<T> getAllVertexObject(){
        Vertex<T,N> temp=head;
        ArrayList<T> arrayList=new ArrayList<>();
        while(temp!=null){
            arrayList.add(temp.vertexInfo);
            temp=temp.nextVertex;
        }
        return arrayList;
    }
    public ArrayList <Vertex<T,N>>getAllVertices(){
        Vertex<T,N> temp=head;
        ArrayList<Vertex<T,N>> arrayList=new ArrayList<>();
        while(temp!=null){
            arrayList.add(temp);
            temp=temp.nextVertex;
        }
        return arrayList;
    }
    public T getVertex(int pos) {
        if (pos < 0 || pos >= size)
            return null;

        Vertex<T, N> temp = head;
        for (int i = 0; i < pos; i++)
            temp = temp.nextVertex;
        return temp.vertexInfo;
    }
    public boolean hadEdge(T fromVertex, T toVertex){
        if (head==null) return false;
        if (!(hadVertex(fromVertex)||!(hadVertex(toVertex)))) return false;
        Vertex<T,N> oriFromVertex=head;
        while(oriFromVertex!=null){
            if(oriFromVertex.vertexInfo.compareTo(fromVertex)==0){
                Edge<T,N> temp=oriFromVertex.firstEdge;
                while(temp!=null){
                    if (temp.toVertex.vertexInfo.compareTo(toVertex)==0){
                        return true;
                    }
                    temp=temp.nextEdge;
                }
            }
            oriFromVertex=oriFromVertex.nextVertex;
        }
        return false;
    }
    public N getEdgeWeight(T source,T destination){
        if(!(hadVertex(source))||!(hadVertex(destination))) return null;
        for (Vertex<T,N> temp=head;temp!=null;temp=temp.nextVertex){
            if(temp.vertexInfo.compareTo(source)==0){
                for (Edge<T,N> temp_edge=temp.firstEdge;temp_edge!=null;temp_edge=temp_edge.nextEdge){
                    if(temp_edge.toVertex.vertexInfo.compareTo(destination)==0){
                        return temp_edge.weight;
                    }
                }
            }
        }
        return null;
    }
    public ArrayList<T> getNeighbour(T t){
        if(!hadVertex(t)) return null;
        ArrayList<T> list_neighbour=new ArrayList<>();
        for (Vertex<T,N> temp=head;temp!=null;temp=temp.nextVertex){
            if (temp.vertexInfo.compareTo(t)==0){
                for (Edge<T,N> temp_edge=temp.firstEdge;temp_edge!=null;temp_edge=temp_edge.nextEdge){
                    list_neighbour.add(temp_edge.toVertex.vertexInfo);
                }
            }
        }
        return list_neighbour;
    }
    public void printEdges(){
        for (Vertex<T,N> temp=head;temp!=null;temp=temp.nextVertex){
            System.out.println("Current Vertex : "+temp.vertexInfo);
            for (Edge<T,N> temp_edge=temp.firstEdge;temp_edge!=null;temp_edge=temp_edge.nextEdge){
                System.out.printf("\n[%s %s]",temp.vertexInfo,temp_edge.toVertex.vertexInfo);
            }
        }
    }
    //Question 1
    public boolean addUndirectedEdge(T source, T destination, N weight){
        return addEdge(source, destination, weight) && addEdge(destination, source, weight);
    }
    //Question 2
    public boolean removeEdge(T source, T destination){
        if(!hadVertex(source) || !hadVertex(destination)) return false;

        for(Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex){
            if(sourceVertex.vertexInfo.compareTo(source) == 0){
                for(Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge){
                    if(currentEdge.toVertex.vertexInfo.compareTo(destination) == 0){
                        Edge<T, N> removedEdge = currentEdge;
                        sourceVertex.firstEdge = currentEdge.nextEdge;
                        sourceVertex.outDegree--;
                        return true;
                    }
                }
            }
        }
        return false;
    }

}