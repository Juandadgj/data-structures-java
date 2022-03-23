public class Node {
    public Node father;
    public Node rigth;
    public Node left;
    public String key;

    public Node(String index) {
        key = index;
        rigth = null;
        left = null;
        father = null;
    }
}
