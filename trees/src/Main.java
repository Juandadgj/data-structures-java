import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("D:\\Juandadgj\\Desktop\\TreesExercise\\src\\estudiantes.txt");
            BufferedReader br = new BufferedReader( fr );
            String composed = br.readLine();
            Tree tree = new Tree();

            String compuesto1;

            while (composed != null) {
                compuesto1 = br.readLine ();

                long CC = Long.parseLong ( composed.substring ( 0, 11 ) );
                String surname1 = composed.substring ( 16, 26 );
                String surname2 = composed.substring ( 32, 42 );
                String names = composed.substring ( 48, 64 );
                String email = composed.substring ( 68, 98 );
                tree.insert( CC, surname1, surname2, names, email );
                composed = compuesto1;
            }
            br.close ();

            tree.travel(tree.root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

