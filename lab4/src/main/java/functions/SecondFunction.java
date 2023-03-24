package functions;

public class SecondFunction extends Function{
    @Override
    public double f(double x) {
        return Math.exp(x);
    }

    @Override
    public String toString() {
        return "e^x";
    }
}
