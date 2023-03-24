package math.methods;

import math.equations.Equation;

public class ChordMethod {
    double a = 0;
    double b = 0;
    double E = 0;
    double x_chord = 0;
    int n = 0;

    public ChordMethod(double a, double b, double E, double x, double x_chord) {
        this.a = a;
        this.b = b;
        this.E = E;
        this.x_chord = x_chord;
    }

    public void hordMethod(Equation equation) {
        double this_a = a;
        double this_b = b;
        double x_prev, c = 0;
        n = 0;
        do {
            x_prev = c;
            c = (this_a * equation.f(this_b) - this_b * equation.f(this_a)) / (equation.f(this_b) - equation.f(this_a));
            if ((equation.f(c) > 0) && (equation.f(this_a) < 0)) {
                this_b = c;
            } else {
                this_a = c;
            }
            n++;
        } while ((Math.abs(c - x_prev) > E) || (equation.f(c) > E));
        x_chord = c;
    }

    public double getX_chord() {
        return x_chord;
    }

    public int getN() {
        return n;
    }
}
