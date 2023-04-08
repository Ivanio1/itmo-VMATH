package methods;
import equations.Equation;
import java.util.ArrayList;


public class RungeKutta  {
    public TableOfDots solve(Equation equation, double a, double b, double y0, double h) {
        ArrayList<Double> X = new ArrayList<>();
        ArrayList<Double> Y = new ArrayList<>();
        X.add(a);
        Y.add(y0);
        int i = 1;
        for (double x = a; x + h <= b; i++) {
            double yPrevious = Y.get(Y.size() - 1);
            double k1 = h * equation.function(x, yPrevious);
            double k2 = h * equation.function(x + h / 2, yPrevious + k1 / 2);
            double k3 = h * equation.function(x + h / 2, yPrevious + k2 / 2);
            double k4 = h * equation.function(x + h, yPrevious + k3);
            double yNext = yPrevious + 1f / 6 * (k1 + 2 * k2 + 2 * k3 + k4);
            Y.add(yNext);
            x += h;
            X.add(x);
        }

        return new TableOfDots(X, Y);
    }
}
