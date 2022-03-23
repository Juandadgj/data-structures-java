
public class Queue {

    protected Node front;
    protected Node end;
    public int length;

    public boolean emptyQueue() {
        return (front == null);
    }

    public Queue() {
        front = end = null;
    }

    public void insert(int element) {
        Node a;
        a = new Node(element);
        if (emptyQueue()) {
            front = a;
        } else {
            end.next = a;
        }
        end = a;
        length++;
    }

    public int delete() throws Exception {
        int aux;
        if (!emptyQueue()) {
            aux = front.value;
            front = front.next;
        } else
            throw new Exception("Empty queue");
        return aux;
    }

    public void clearQueue() {
        for (; front != null;) {
            front = front.next;
        }
        System.gc();
    }

    public int frontQueue() throws Exception {
        if (emptyQueue()) {
            throw new Exception("Empty queue");
        }
        return (front.value);
    }

    public void show() throws Exception {
        String aux = front.value + "";
        if (emptyQueue()) {
            System.out.print("Empty queue");
        }
        for (int i = 1; i < length; i++){
            front = front.next;
            aux = frontQueue() + aux;
        }
        System.out.println(aux);
    }
}
