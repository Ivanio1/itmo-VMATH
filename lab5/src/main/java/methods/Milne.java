package methods;
import equations.Equation;
import java.util.ArrayList;


public class Milne  {
    private final RungeKutta rungeKutta = new RungeKutta();
    public TableOfDots solve(Equation equation, double a, double b, double y0, double h, Double precision) {
        var data = rungeKutta.solve(equation, a, a + 3.5 * h, y0, h);
        ArrayList<Double> X = data.getXs();
        ArrayList<Double> Y = data.getYs();
        ArrayList<Double> F = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            F.add(equation.function(X.get(i), Y.get(i)));
        }
        int i = 4;
        for (double x = X.get(X.size() - 1) + h; x <= b; i++) {
            double yNext = Y.get(Y.size() - 4) + 4 * h * (2 * F.get(0) - F.get(1) + 2 * F.get(2)) / 3;
            double fNext = equation.function(x, yNext);
            double yCheck = Y.get(Y.size() - 2) + h * (F.get(1) + 4 * F.get(2) + fNext) / 3;
            while (Math.abs(yCheck - yNext) > precision) {
                yNext = yCheck;
                fNext = equation.function(x, yNext);
                yCheck = Y.get(Y.size() - 2) + h * (F.get(1) + 4 * F.get(2) + fNext) / 3;
            }
            Y.add(yNext);
            F.set(0, F.get(1));
            F.set(1, F.get(2));
            F.set(2, fNext);
            X.add(x);
            x += h;
        }
        return new TableOfDots(X, Y);
    }
}
