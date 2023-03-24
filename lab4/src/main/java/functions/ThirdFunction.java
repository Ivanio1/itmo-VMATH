package functions;

public class ThirdFunction extends Function{
    @Override
    public double f(double x) {
        return Math.cos(x);
    }

    @Override
    public String toString() {
        return "cos(x)";
    }
}
