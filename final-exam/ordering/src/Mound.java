
public class Mound {
    static final int TAMINI = 20;
    private int numElem;
    private Comparator[] v;

    public Mound() {
        numElem = 0;
        v = new Comparator[TAMINI];
    }

    public static int childLeft(int i) {
        return (2 * i + 1);
    }

    public static int childRigth(int i) {
        return (2 * i + 1) + 1;
    }

    public static void criba(Comparator v[], int root, int last) {
        boolean isMound;
        int child;
        int numElem = last + 1;
        isMound = false;
        while ((root < numElem / 2) && !isMound) {
            if (Mound.childLeft(root) == (numElem - 1))
                child = Mound.childLeft(root);
            else {
                if (v[Mound.childLeft(root)].greatherThan(v[Mound.childRigth(root)]))
                    child = Mound.childLeft(root);
                else
                    child = Mound.childRigth(root);
            }
            if (v[child].greatherThan(v[root])) {
                Comparator t = v[root];
                v[root] = v[child];
                v[child] = t;
                root = child; /* continua por la rama de claves máximas */
            } else
                isMound = true;
        }
    }

    public static void orderingMound(Comparator v[], int n) {
        int j;
        for (j = n / 2; j >= 0; j--)
            criba(v, j, n - 1);
        for (j = n - 1; j >= 1; j--) {
            Comparator t;
            t = v[0];
            v[0] = v[j];
            v[j] = t;
            criba(v, 0, j - 1);
        }
    }

}
