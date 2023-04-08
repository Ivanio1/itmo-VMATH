package equations;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class FirstEquation extends Equation{
    private double c;
    @Override
    public double function(double x, double y) {
        return x*y;
    }

    @Override
    public double exactValueFunction(double x) {
        return c * exp(pow(x, 2) / 2);
    }

    @Override
    public void calculateC(double x, double y) {
        c= y / exp(pow(x, 2) / 2);
    }

    @Override
    public String toString() {
        return "y' = x * y";
    }
}
