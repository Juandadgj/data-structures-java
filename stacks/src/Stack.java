
public class Stack {

    private NodeStack top;

    public Stack(){
        top = null;
    }

    public boolean emptyStack() {
        return top == null;
    }

    public void insert(int elemento) {
        NodeStack recent;
        recent = new NodeStack(elemento);
        recent.next = top;
        top = recent;
    }

    public int delete() throws Exception {
        if (emptyStack()) {
            throw new Exception("Empty stack, cannot be removed.");
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
            System.out.print("Empty stack");
        }
        while (!emptyStack()) {
            aux = top.value;
            top = top.next;
            System.out.print(aux + " ");
        }
    }
}
