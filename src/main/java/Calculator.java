public class Calculator {
    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double divide(Double a, Double b) {
        if (b == 0)
            throw new IllegalArgumentException("division by 0");
        return a / b;
    }
}
