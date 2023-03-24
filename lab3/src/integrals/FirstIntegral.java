package integrals;

public class FirstIntegral extends Integral {
    @Override
    public double f(double x) {
        return (Math.pow(x, 2) + 1) / 2;
    }
}
