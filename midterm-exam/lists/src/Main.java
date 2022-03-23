import java.util.ArrayList;

public class Main {

    static SimpleList simpleList1 = new SimpleList();
    static SimpleList simpleList2 = new SimpleList();
    static ArrayList<SimpleList> productList = new ArrayList<>();

    public static SimpleList productoPolinomio(SimpleList simpleList1, SimpleList simpleList2) {
        Node currentMinor, currentMajor, assistant;
        if (simpleList1.size < simpleList2.size) {
            currentMinor = simpleList1.first;
            assistant = simpleList2.first;
        } else {
            currentMinor = simpleList2.first;
            assistant = simpleList1.first;
        }

        int product;
        while (currentMinor != null) {
            SimpleList listaProductoPolinomio = new SimpleList();
            currentMajor = assistant;
            while (currentMajor != null) {
                if (currentMinor.getExponent() == null && currentMajor.getExponent() == null) {
                    product = currentMinor.getCoefficient() * currentMajor.getCoefficient();
                    listaProductoPolinomio.add(new Node(product, null));
                } else if (currentMinor.getExponent() != null && currentMajor.getExponent() == null) {
                    product = currentMinor.getCoefficient() * currentMajor.getCoefficient();
                    listaProductoPolinomio.add(new Node(product, currentMinor.getExponent()));
                } else if (currentMinor.getExponent() == null && currentMajor.getExponent() != null) {
                    product = currentMinor.getCoefficient() * currentMajor.getCoefficient();
                    listaProductoPolinomio.add(new Node(product, currentMajor.getExponent()));
                } else {
                    product = currentMinor.getCoefficient() * currentMajor.getCoefficient();
                    listaProductoPolinomio.add(new Node(product, currentMinor.getExponent() + currentMajor.getExponent()));
                }
                currentMajor = currentMajor.getNext();
            }
            productList.add(listaProductoPolinomio);
            currentMinor = currentMinor.getNext();
        }

        SimpleList sumaDoble = sumarPolinomios(productList.get(2), productList.get(1));
        return sumarPolinomios(sumaDoble, productList.get(0));
    }

    public static SimpleList sumarPolinomios(SimpleList simpleList1, SimpleList simpleList2) {
        Node current1 = simpleList1.first;
        Node current2 = simpleList2.first;
        SimpleList simpleList3 = new SimpleList();
        int suma = 0, control = 0;

        while (control < simpleList1.size) {
            if (current2 != null) {
                if (current1.getExponent() != null && current2.getExponent() != null) { //Ambos exponentes diferentes de null
                    if (current1.getExponent() == current2.getExponent()) { //Exponentes iguale
                        suma = current1.getCoefficient() + current2.getCoefficient();
                        simpleList3.add(new Node(suma, current1.getExponent()));
                        current1 = current1.getNext();
                        current2 = current2.getNext();
                        control++;
                    } else if (current1.getExponent() > current2.getExponent()) { //Expo1 mayor al Expo2
                        simpleList3.add(new Node(current1.getCoefficient(), current1.getExponent()));
                        current1 = current1.getNext();
                        control++;
                    } else { //Expo2 mayor al Expo1
                        simpleList3.add(new Node(current2.getCoefficient(), current2.getExponent()));
                        current2 = current2.getNext();
                    }
                } else { //Uno solo exponente diferente de null
                    if (current1.getExponent() == null && current2.getExponent() != null) { //
                        simpleList3.add(new Node(current2.getCoefficient(), current2.getExponent()));
                        current2 = current2.getNext();
                    } else if (current2.getExponent() == null && current1.getExponent() != null) {
                        simpleList3.add(new Node(current1.getCoefficient(), current1.getExponent()));
                        current1 = current1.getNext();
                        control++;
                    } else {
                        suma = current1.getCoefficient() + current2.getCoefficient();
                        simpleList3.add(new Node(suma, null));
                        current1 = null; //-22x
                        current2 = null; //null
                        control++;
                    }
                }
            }else{
                if (current1.getExponent() != null) {
                    simpleList3.add(new Node(current1.getCoefficient(), current1.getExponent()));
                    current1 = current1.getNext();
                }else {
                    simpleList3.add(new Node(current1.getCoefficient(), current1.getExponent()));
                    current1 = null;
                }
                control++;
            }
        }
        return simpleList3;
    }

    public static void main(String[] args) {

        Node polynomial1 = new Node(3, 3);
        simpleList1.add(polynomial1);
        polynomial1 = new Node(-5, 2);
        simpleList1.add(polynomial1);
        polynomial1 = new Node(4, null);
        simpleList1.add(polynomial1);

        simpleList1.show();

        Node polynomial2 = new Node(7, 4);
        simpleList2.add(polynomial2);
        polynomial2 = new Node(4, 3);
        simpleList2.add(polynomial2);
        polynomial2 = new Node(-9, 2);
        simpleList2.add(polynomial2);
        polynomial2 = new Node(2, null);
        simpleList2.add(polynomial2);

        System.out.println("\n");

        simpleList2.show();

        System.out.println("\n");

        productoPolinomio(simpleList1, simpleList2).show();


    }
}

