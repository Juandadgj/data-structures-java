
public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public void insert(long id, String surname, String secSurname, String name, String mail) {
        Node n = new Node(id);
        n.content = surname;
        n.mail = mail;

        if (root == null) {
            root = n;
        } else {
            Node aux = root;
            while (aux != null) {

                n.father = aux;

                if (n.key >= aux.key) {
                    aux = aux.rigth;
                } else {
                    aux = aux.left;
                }
            }

            if (n.key < n.father.key) {

                n.father.left = n;
            } else {

                n.father.rigth = n;
            }
        }
    }

    public void travel(Node n) {

        if (n != null) {
            travel( n.left);
            System.out.println ( "ID: "+n.key + " Surname: "+ n.content + " Mail: " + n.mail);
            travel( n.rigth);
        }
    }
}

