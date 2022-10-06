package a5;
import java.util.*;
public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */

    private String name;
    private boolean settled;
    private LinkedList<Edge> adj_lists;

    public NodeImpl(String name) {
        this.name = name;
        this.adj_lists = new LinkedList<>();
        this.settled = false;
    }
    public NodeImpl(String name, LinkedList<Edge> adj_lists, boolean settled ) {
        this.name = name;
        this.adj_lists = adj_lists;
        this.settled = settled;
    }

    public LinkedList<Edge> getAdj_lists() {return adj_lists;}

    public String getName() { return this.name; }

    public void setSettled(boolean settled) {this.settled = settled;}

    public boolean isSettled() {return settled;}

    public void setName(String name){ this.name = name; }


}
