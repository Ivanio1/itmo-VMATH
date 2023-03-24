package integrals;

public class SecondIntegral extends Integral{
    @Override
    public double f(double x) {
        return  (Math.pow(x, 3) + 2 * Math.pow(x, 2) - x + 1);
    }
}
