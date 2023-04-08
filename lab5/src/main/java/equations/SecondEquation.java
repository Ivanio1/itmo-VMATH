package equations;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class SecondEquation extends Equation {
    private double c;
    @Override
    public double function(double x, double y) {
        return Math.sin(x) + y;
    }

    @Override
    public double exactValueFunction(double x) {
        return -sin(x) / 2 - cos(x) / 2 + c * exp(x);
    }

    @Override
    public void calculateC(double x, double y) {
        c= (y + sin(x) / 2 + cos(x) / 2) / exp(x);
    }

    @Override
    public String toString() {
        return "y' = sin(x) + y";
    }
}
