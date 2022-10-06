package a5;
import java.util.*;
public class Main {


    public static void main(String[] args) {

        //You are encouraged (but not required) to include your testing code here.
//        Node a = new NodeImpl("A");
//        Node b = new NodeImpl("B");
//        Node c = new NodeImpl("C");
//        Node d = new NodeImpl("D");
//        Node e = new NodeImpl("E");
//        Node f = new NodeImpl("F");
//        Node g = new NodeImpl("G");
//        Graph dg = new GraphImpl();
//        dg.addNode("A");
//        dg.addNode("B");
//        dg.addNode("C");
//        dg.addNode("D");
//        dg.addNode("E");
//        dg.addNode("F");
//        dg.addNode("G");
//        dg.addEdge("A","B",2);
//        dg.addEdge("B","A",2);
//        dg.addEdge("A","D",1);
//        dg.addEdge("B","D",3);
//        dg.addEdge("B","E",1);
//        dg.addEdge("C","A",4);
//        dg.addEdge("C","F",5);
//        dg.addEdge("D","C",2);
//        dg.addEdge("D","E",3);
//        dg.addEdge("D","F",8);
//        dg.addEdge("D","G",4);
//        dg.addEdge("E","G",6);
//        dg.addEdge("G","F",1);
//        dg.deleteEdge("A", "B");
//        dg.deleteNode("A");
//        dg.deleteNode("A");
        Graph dg = new GraphImpl();
        int gsize = 1000000;
        Random randomNum = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int N = alphabet.length();
        String[] n = new String[gsize];
        for (int i = 0; i< gsize; i++){
            String name = "";
            for(int j = 0; j < 5;j++){
                name = name + alphabet.charAt(randomNum.nextInt(N));
            }
            n[i] = name;
        }

        for(int i = 0; i < gsize; i++){
            dg.addNode(n[i]);
        }
        for(int i = 0; i<(gsize * 13); i++){
            String source = n[Math.abs((randomNum.nextInt())%gsize)];
            String dest = n[Math.abs((randomNum.nextInt())%gsize)];
            dg.addEdge(source, dest, 1);
        }
        System.out.println("Graph has " + dg.numNodes() + " nodes and " + dg.numEdges() + " edges.");
        Map< String, Double> pathlengths;
        pathlengths = dg.dijkstra(n[randomNum.nextInt(gsize)]);
    }


}
