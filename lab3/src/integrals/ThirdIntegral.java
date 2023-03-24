package integrals;

public class ThirdIntegral extends Integral{
    @Override
    public double f(double x) {
        return Math.sin(x+1);
    }
}
