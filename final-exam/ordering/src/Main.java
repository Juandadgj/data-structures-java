
public class Main {

    public static void main(String[] args) {
        Number a[] = {new Number(18), new Number(11), new Number(22), new Number(33), new Number(11)
                , new Number(34), new Number(44), new Number(2), new Number(8), new Number(11)};
        Mound.orderingMound(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
