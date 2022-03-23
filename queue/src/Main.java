
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    static Stack stack1 = new Stack();
    static Stack stack2 = new Stack();
    static Stack stack3 = new Stack();
    static Queue queue1 = new Queue();
    static Queue queue2 = new Queue();

    public static void main(String[] args) throws Exception {
        String fichero = "entrada.txt";
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            for (char digito : linea.toCharArray()) {
                Node nuevo = new Node(Integer.parseInt(digito + ""));
                stack1.insert(nuevo.value);
            }
            linea = br.readLine();
            for (char digito : linea.toCharArray()) {
                Node nuevo = new Node(Integer.parseInt(digito + ""));
                stack2.insert(nuevo.value);
            }

            Queue prueba = suma(stack1, stack2);
            prueba.show();
            linea = br.readLine();

            while (linea != null) {
                for (char digito : linea.toCharArray()) {
                    Node nuevo = new Node(Integer.parseInt(digito + ""));
                    stack3.insert(nuevo.value);
                }

                prueba = sumaPilaCola(prueba, stack3);
                prueba.show();

                stack3 = new Stack();
                linea = br.readLine();
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Queue sumaPilaCola(Queue queue1, Stack stack3) throws Exception {
        int suma = 0;
        while (!queue1.emptyQueue()) {
            if (!stack3.emptyStack()) {
                suma += queue1.frontQueue() + stack3.topStack();
                queue2.insert(suma % 10);
                if (suma > 9) {
                    suma = 1;
                } else {
                    suma = 0;
                }
                stack3.delete();
            } else {
                queue2.insert(queue1.frontQueue());
            }
            queue1.delete();
        }
        if (suma == 1) {
            queue2.insert(1);
        }
        return queue2;
    }

    private static Queue suma(Stack stack1, Stack stack2) throws Exception {
        Stack actualMenor, actualMayor;
        if (stack1.length > stack2.length) {
            actualMayor = stack1;
            actualMenor = stack2;
        } else {
            actualMayor = stack2;
            actualMenor = stack1;
        }

        int suma = 0;
        while (!actualMayor.emptyStack()) {
            if (!actualMenor.emptyStack()) {
                suma += actualMayor.topStack() + actualMenor.topStack();
                queue1.insert(suma % 10);
                if (suma > 9) {
                    suma = 1;
                } else {
                    suma = 0;
                }
                actualMenor.delete();
            } else {
                queue1.insert(actualMayor.topStack());
            }
            actualMayor.delete();
        }
        if (suma == 1) {
            queue1.insert(1);
        }
        return queue1;
    }
}
