package a5;

public class EdgeImpl implements Edge {
    /* You will include the implementations for any edge methods you need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */
    private Node src;
    private Node dest;
    private double weight;

    /*Also, any edge fields you want to add for the object should go in this file.  */
    public EdgeImpl(Node src, Node dest, double weight){
//        this.name = name;
        this.src = src; //src = source
        this.dest = dest;
        this.weight = weight;
    }
    public EdgeImpl(Node src, Node dest){
        this.src = src; //src = source
        this.dest = dest;
        this.weight =1.0; }

    public Node getSrc(){return src;}
    public Node getDest(){return dest;};
    public double getWeight(){return weight;}

    public void setSrc(Node src){this.src = src;}
    public void setDest(Node dest){this.dest = dest;}
    public void setWeight(double weight){this.weight = weight;}
}
