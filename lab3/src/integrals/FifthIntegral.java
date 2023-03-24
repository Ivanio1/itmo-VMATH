package integrals;

public class FifthIntegral extends Integral{
    @Override
    public double f(double x) {
        return Math.sin(x)/x;
    }
}
