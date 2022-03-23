import java.util.ArrayList;

public class Main {

    static ArrayList<Stack> listStack = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        System.out.println("Juan Daniel Guerrero");

        Stack stack1 = new Stack();
        listStack.add(stack1);
        Stack stack2 = new Stack();
        listStack.add(stack2);
        Stack stack3 = new Stack();
        listStack.add(stack3);
        Stack stack4 = new Stack();
        listStack.add(stack4);
        Stack stack5 = new Stack();
        listStack.add(stack5);

        fillStack(1, 35);
        fillStack(1, 56);
        fillStack(1, 78);
        fillStack(-1, 53);
        fillStack(2, 76);
        fillStack(2, 87);
        fillStack(2, 74);
        fillStack(3, 62);
        fillStack(3, 231);
        fillStack(3, 0);
        fillStack(4, 54);
        fillStack(4, 96);
        fillStack(5, 21);
        fillStack(5, 15);
        fillStack(5, 84);
        fillStack(5, 32);
        fillStack(5, 63);
        fillStack(-5,39);
        fillStack(6, 17);

        showStack();

    }

    private static void fillStack(int i, int j) throws Exception {
        if (Math.abs(i) > 0 && Math.abs(i) < 6) {
            Stack actual = listStack.get(Math.abs(i)-1);

            if (i > 0) { //se agrega
                actual.insert(j);
            } else { //se elimina
                Stack auxiliar = new Stack();

                while (!actual.emptyStack()) {
                    if (actual.topStack() == j) {
                        actual.delete();
                        break;
                    }
                    auxiliar.insert(actual.delete());
                }
                if (!auxiliar.emptyStack()){
                    while (!auxiliar.emptyStack()) {
                        actual.insert(auxiliar.delete());
                    }
                }
            }
        }
    }

    private static void showStack() throws Exception{
        for (int i = 0; i< listStack.size(); i++){
            Stack actual = listStack.get(Math.abs(i));
            System.out.print("\n"+"Stack " + (i+1)+": ");
            actual.show();
        }
    }
}

