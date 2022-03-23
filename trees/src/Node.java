
class Node {
    public Node father;
    public Node rigth;
    public Node left;
    public long key;
    public Object content;
    public String mail;

    public Node(long indice) {
        key = indice;
        rigth = null;
        left = null;
        father = null;
        content = null;
        mail = null;
    }
}
