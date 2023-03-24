package math.methods;

import math.equations.Equation;

public class BisectionMethod {
    double a = 0;
    double b = 0;
    double E = 0;
    double x = 0;
    double x_half = 0;
    int n = 0;

    public BisectionMethod(double a, double b, double E, double x, double x_half) {
        this.a = a;
        this.b = b;
        this.E = E;
        this.x = x;
        this.x_half = x_half;
    }

    public void halfMethod(Equation equation) {
        double this_a = a;
        double this_b = b;
        n = 0;
        while (Math.abs(this_b - this_a) > E || Math.abs(equation.f(x)) > E) {
            x = (this_a + this_b) / 2;
            n++;
            if (equation.f(this_a) * equation.f(x) < 0) {
                this_b = x;
            } else {
                this_a = x;
            }
        }
        x_half = x;
    }

    public double getX_half() {
        return x_half;
    }

    public int getN() {
        return n;
    }
}
