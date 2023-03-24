package methods;


import exceptions.FunctionNotDefinedException;
import exceptions.IrremovableGapException;
import integrals.Integral;
import utils.GapsHandler;


import java.util.List;

public abstract class RectangleMethod {

    public abstract List<Double> solve(Integral integral, double a, double b, double e, int n, double numberOfClosing) throws IrremovableGapException, FunctionNotDefinedException;

    static double getFunctionValue(Double functionValue, double x, Integral integral, double numberOfClosing) throws IrremovableGapException, FunctionNotDefinedException {
        if (functionValue.isNaN() || functionValue.isInfinite()) {
            if (GapsHandler.IsFunctionDefine(integral, x)) {
                if (GapsHandler.IsPossibleToCloseTheGap(integral, x)) {
                    functionValue = closeGap(numberOfClosing, x, integral);
                } else throw new IrremovableGapException(x, 2);
            } else throw new FunctionNotDefinedException();
        }
        return functionValue;
    }

    static double closeGap(double numberOfClosing, double x, Integral integral) {
        double result = 0;
        if (numberOfClosing == 1) {
            result = (integral.f(x - 0.00001) + integral.f(x + 0.00001)) / 2.0;
        } else {
            result = numberOfClosing;
        }
        return result;
    }
}
