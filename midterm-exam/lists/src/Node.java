public class Node {
    Node next;
    Integer coefficient, exponent;

    public Node(Integer coeficiente, Integer exponent) {
        this.coefficient = coeficiente;
        this.exponent = exponent;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getExponent() {
        return exponent;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }
}

