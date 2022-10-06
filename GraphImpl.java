package a5;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
                             // key: name of node. value: a5.Node object associated with name
    private final Map<Node, List<Edge>> adj_lists;

    public GraphImpl() {
        nodes = new HashMap<>();
        adj_lists = new HashMap<>();}

    @Override
    public int numNodes() {return nodes.size();}//Dummy return value.  Remove when you implement!

    @Override
    public boolean addNode(String name) {
        if (nodes.containsKey(name)) return false;

        Node node = new NodeImpl(name);
        nodes.put(name, node);
        adj_lists.put(node, new ArrayList<>());
        //System.out.println("Added node: " + name);
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        //Hint: Do you need to remove edges when you delete a node?
        if (!nodes.containsKey(name)) {
            //System.out.println("node does not exist");
            return false;
        }
        for(Node c : adj_lists.keySet()){
            deleteEdge(c.getName(), name);
            deleteEdge(name, c.getName());
        }
        Node node = nodes.get(name);
        nodes.remove(name);
        adj_lists.remove(node);
        //System.out.println("deleted node: " + name);
        return true;
    }
    public boolean hasNode(Node n){ return adj_lists.containsKey(n);}

    @Override
    public int numEdges() {
        int num = 0;
        for(Node n : nodes.values()){
            List<Edge> edges = adj_lists.get(n);
            int i = edges.size();
            num += i;
            }
        return num;}  //Dummy return value.  Remove when you implement!

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight<0.0 || !nodes.containsKey(src) || !nodes.containsKey(dest)) {
            //System.out.println("The weight is either zero (weight: " + weight + ") or the nodes do not contain the dest or src");
            return false;
        }

        if(hasEdge(src, dest)) return false;

        Edge e = new EdgeImpl(nodes.get(src), nodes.get(dest), weight);
        adj_lists.get(nodes.get(src)).add(e);
        //System.out.println("Added edge where source node is: " + src + " destination is: " + dest + " and weight is: "+ weight);
        return true;  //Dummy return value.  Remove when you implement!
    }

    private boolean hasEdge(String src, String dest){return findEdge(nodes.get(src), nodes.get(dest)) != null;}

    private Edge findEdge(Node src, Node dest){
        if(!nodes.containsKey(src.getName()) || !nodes.containsKey(dest.getName()))return null;

        List<Edge> edges = adj_lists.get(src);
        for( Edge e : edges){

            if(e.getDest() == dest) return e;
        }
        return null;
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if(!hasEdge(src, dest)){return false;}
        Edge e = findEdge(nodes.get(src), nodes.get(dest));
        adj_lists.get(nodes.get(src)).remove(e);
        //System.out.println("deleted edge where source node is: " + src + " destination is: " + dest );
        return true;
    }

    public Node[] getNeighbors(Node n){
        List<Edge> direct_edges = adj_lists.get(n);
        Node[] neighbors = new Node[direct_edges.size()];
        for(int i = 0; i < direct_edges.size(); i++){
            neighbors[i] = direct_edges.get(i).getDest();
        }
        return neighbors;
    }
    public double getWeight(Node src, Node dest){
        if (hasEdge(src.getName(), dest.getName())){
            Edge edge = findEdge(src, dest);
            return edge.getWeight();
        }
        return 0.0;
    }
    @Override
    public Map<String, Double> dijkstra(String start) {
        // make starting distance 0
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<String, Double> paths = new HashMap<>();

        //set all other distances to an infinite value
        for (String name : nodes.keySet()){
            //System.out.println("on Node '" + name + " '" );
            paths.put(name, Double.POSITIVE_INFINITY);
        }

        //the start node be 0
        paths.replace(start, 0.0);

        //add start node to unsettled nodes
        pq.add(new Pair(start,0.0));

        //declare variables
        Pair current;
        double dist, neighbordist;
        String nodename;
        //while pq != 0
        while (pq.size() > 0){
            //gets the top value from pq
            current = pq.remove();
            dist = current.dist;
            nodename = current.name;

            //get the neighbors
            Node[] neighbors = getNeighbors(nodes.get(nodename));

            //if current node is not settled go in and compare the neighbors distance
            if(!nodes.get(nodename).isSettled()){

                //change the node to settled
                nodes.get(nodename).setSettled(true);

                //find all the edges weight from current node to neighbors node
                for (Node neighbor: neighbors){
                    neighbordist = getWeight(nodes.get(nodename), neighbor);
                    //System.out.println("The distance of the neighbor is : " + neighbordist);
                    //if the paths distance is greater than dist plus neighbordist then we replace
                    if(!neighbor.isSettled() && paths.get(neighbor.getName()) > dist + neighbordist){
                        paths.replace(neighbor.getName(), dist+neighbordist);
                        //System.out.println("The distance for " + neighbor.getName() + " is: " + dist+neighbordist);
                        pq.add(new Pair(neighbor.getName(), dist + neighbordist));
                    }
                }

            }

        }
        Map<String, Double> shortest = new HashMap<>();

        for(String name: paths.keySet()){
            if(paths.get(name) < Double.POSITIVE_INFINITY){
                shortest.put(name, paths.get(name));
            }
        }

        return shortest;

    }
class Pair implements Comparable<Pair>{
        public Double dist;
        public String name;

        public Pair(String name, Double dist){
            this.name = name;
            this.dist = dist;
        }

    public void setName(String name) {
        this.name = name;
    }

    public void setDist(Double dist) {
        this.dist = dist;
    }

    public String getName() {
        return name;
    }

    public Double getDist() {
        return dist;
    }

    @Override
    public int compareTo(Pair obj) {
        return Double.compare(this.dist, obj.dist);
    }
}

}
