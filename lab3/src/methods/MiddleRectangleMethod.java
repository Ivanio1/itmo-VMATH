package methods;

import exceptions.FunctionNotDefinedException;
import exceptions.IrremovableGapException;
import integrals.Integral;

import java.util.ArrayList;
import java.util.List;

public class MiddleRectangleMethod extends RectangleMethod {
    private static double summ;
    private static double answer;
    private static double currentE;
    private static double previousAns;

    @Override
    public List<Double> solve(Integral integral, double a, double b, double e, int n, double numberOfClosing) throws IrremovableGapException, FunctionNotDefinedException {
        answer = 0;
        currentE = Double.MAX_VALUE;
        double h;
        double currentA;

        List<Double> list = new ArrayList<>();

        while (currentE > e) {
            currentA = a;
            summ = 0;
            h = (b - a) / n;
            for (int i = 1; i <= n; i++) {
                currentA += h;
                summ += RectangleMethod.getFunctionValue(integral.f(currentA - h / 2), currentA - h / 2, integral,numberOfClosing);;
            }

            previousAns = answer;
            answer = summ * h;
            n = n * 2;
            currentE = Math.abs(previousAns - answer);
        }
        list.add(0, (double) n);
        list.add(1, answer);
        return list;
    }
}
