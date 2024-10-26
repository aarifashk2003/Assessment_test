
package ruleengine;

public class Node {
    public String type; // "operator" or "operand"
    public String value; // e.g., "age > 30"
    public Node left; // left child node
    public Node right; // right child node

    // Constructor for Node with type and value
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Constructor for operator Node
    public Node(String type) {
        this.type = type;
        this.left = null;
        this.right = null;
    }
}
