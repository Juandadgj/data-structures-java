public class Tree {
    Node root;

    public Tree() {
        root = null;
    }
    public void insert(String Name) {
        Node n = new Node( Name );
        if (root == null) {
            root = n;
        } else {
            Node aux = root;
            while (aux != null) {
                n.father = aux;
                if (n.key.compareTo ( aux.key) >= 0) {
                    aux = aux.rigth;
                } else {
                    aux = aux.left;
                }
            }
            if (n.key.compareTo ( n.father.key) < 0) {
                n.father.left = n;
            } else {
                n.father.rigth = n;
            }
        }
    }
    public void travel(Node n) {
        if (n != null) {
            travel( n.left);
            System.out.println ( "Nombre: " + n.key);
            travel( n.rigth);
        }
    }

}
