package utils;


import equations.Equation;
import equations.FirstEquation;
import equations.SecondEquation;
import methods.Milne;
import methods.TableOfDots;
import methods.interpolation.Spline;
import methods.interpolation.SplineMethod;

public class CalculationHandler {
    Milne milne = new Milne();

    public void startCalculation() throws Exception {
        double a, b;
        double h;
        double e;
        double y0;
        Inputer inputer = new Inputer();
        int option = inputer.inputEquation();
        Equation equation = getEqByNumber(option);
        a = inputer.inputLeftBorder();
        b = inputer.inputRightBorder();
        y0 = inputer.inputStartCondition(a);
        equation.calculateC(a, y0);
        h = inputer.inputStep();
        e = inputer.inputEpsilon();

        TableOfDots result = milne.solve(equation, a, b, y0, h, e);
        String addition=String.format(" (x0 = %s, y(x0) = %s)",a,y0);
        SplineMethod splineMethod = new SplineMethod(result.getXs(), result.getYs(), result.getYs().size());
        Spline spline = splineMethod.findSpline();
        Graphic.drawChart(result, equation, spline,addition);
        Printer printer = new Printer();
        printer.finalMessage();
    }


    public Equation getEqByNumber(int n) {
        Equation equation = null;
        if (n == 1) {
            equation = new FirstEquation();
        } else if (n == 2) {
            equation = new SecondEquation();
        }
        return equation;
    }
}
