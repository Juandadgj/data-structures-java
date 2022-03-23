public class SimpleList {
    Node first;
    Integer size = 0;

    public void add(Node current){
        if (first != null){
            findLast().setNext(current);
        }else {
            first = current;
        }
        size++;
    }

    public Node findLast(){
        Node latest = first;

        while (latest.getNext() != null){
            latest = latest.getNext();
        }
        return latest;
    }

    public Double evaluatePolynomial(Integer x){
        double result = 0;
        Node current = first;

        for (int i=0; i<size; i++){
            if (current.getExponent() != null) {
                result += current.getCoefficient() * Math.pow(x, current.getExponent());
                current = current.getNext();
            }else {
                result += current.getCoefficient();
                current = current.getNext();
            }
        }
        return result;
    }

    public void derivePolynomial(){
        Node current = first;
        SimpleList simpleList3 = new SimpleList();
        int derive = 0;

        for (int i=0; i<size; i++){
            if (current.getExponent() != null){
                derive = current.getCoefficient() * current.getExponent();
                simpleList3.add(new Node(derive, current.getExponent() - 1));
                current = current.getNext();
            }else {
                simpleList3.add(null);
            }
        }
        simpleList3.show();
    }


    public void show(){
        Node current = first;

        while (current != null){
            if (current.getExponent() != null) {
                if (current.getExponent() != 1 ){
                    if(current.getExponent() == 0 ){
                        System.out.print(current.getCoefficient());
                    }else {
                        if (current.getCoefficient() > 0 && current != first) {
                            System.out.print("+" + current.getCoefficient() + "x^" + current.getExponent());
                        } else {
                            System.out.print(current.getCoefficient() + "x^" + current.getExponent());
                        }
                    }
                }else {
                    if (current.getCoefficient() > 0 ) {
                        System.out.print("+" + current.getCoefficient() + "x");
                    } else {
                        System.out.print(current.getCoefficient() + "x");
                    }
                }
                current = current.getNext();
            } else {
                if (current.getCoefficient() > 0) {
                    System.out.print("+" + current.getCoefficient());
                    current = current.getNext();
                }else {
                    System.out.print(current.getCoefficient());
                    current = null;
                }
            }
        }
    }
}
