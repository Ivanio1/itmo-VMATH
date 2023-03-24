package utils;

import integrals.Integral;

public class GapsHandler {

    public static boolean IsFunctionDefine(Integral integral, double x) {
        return !Double.isNaN(integral.f(x - 0.00001)) && !Double.isNaN(integral.f(x + 0.00001));
    }

    public static boolean IsPossibleToCloseTheGap(Integral integral, double x) {
        double diffValue = integral.f(x + 0.00001) - integral.f(x - 0.00001);
        return !Double.isNaN(diffValue) && !Double.isInfinite(diffValue) && (diffValue <= 0.00001);
    }


}
