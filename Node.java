package a5;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface Node {

     /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

     /**
      * @return the name of the node*/
     String getName();
     boolean isSettled();
     void setSettled(boolean settled);
     void setName(String name);
     LinkedList<Edge> getAdj_lists();
}
