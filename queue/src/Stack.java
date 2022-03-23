
public class Stack {

    private Node top;
    public int length;

    public Stack(){
        top = null;
    }

    public boolean emptyStack() {
        return top == null;
    }

    public void insert(int element) {
        Node recent;
        recent = new Node(element);
        recent.next = top;
        top = recent;
        length++;
    }

    public int delete() throws Exception {
        if (emptyStack()) {
            throw new Exception("Empty stack");
        }
        int aux = top.value;
        top = top.next;
        return aux;
    }

    public int topStack() throws Exception {
        if (emptyStack()) {
            throw new Exception("Empty stack");
        }
        return top.value;
    }

    public void show(){
        int aux;
        if (emptyStack()) {
            System.out.println("Empty stack");
        }
        while (!emptyStack()) {
            aux = top.value;
            top = top.next;
            System.out.print(aux + " ");
        }
    }

    public void clearStack() {
        Node t;
        while (!emptyStack()) {
            t = top;
            top = top.next;
            t.next = null;
        }
    }
}
