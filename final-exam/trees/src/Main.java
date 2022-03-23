import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static String searchMax(Node r) {
        if (r == null){
            return "Empty";
        }
        String max = r.key;
        while (r.rigth != null){
            r = r.rigth;
            max = r.key;
        }
        return max;
    }

    public static void main(String[] args) {
        String file = "alumnos.txt";
        try {
            FileReader archivo = new FileReader (file);
            BufferedReader buffer = new BufferedReader ( archivo );
            String linea = buffer.readLine ();
            Tree tree = new Tree();
            String linea1;
            while (linea != null) {
                linea1 = buffer.readLine ();
                String Nombre = linea.substring (0,36) ;
                tree.insert(Nombre);
                linea = linea1;
            }
            buffer.close ();
            tree.travel(tree.root);
            searchMax(tree.root);

        } catch (Exception e) {
            System.out.println("Interception " + e);
        }
    }
}
