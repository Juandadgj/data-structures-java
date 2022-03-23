
public class Number implements Comparator {
    int value;

    public Number(int n) {
        value = n;
    }

    public String toString() {
        return " " + value;
    }

    public boolean lessThan(Object op2) {
        Number p2 = (Number) op2;
        return value < p2.value;
    }

    public boolean greatherThan(Object op2) {
        Number p2 = (Number) op2;
        return value > p2.value;
    }
}