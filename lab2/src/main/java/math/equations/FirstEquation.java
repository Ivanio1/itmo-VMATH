package math.equations;

public class FirstEquation extends Equation{

    @Override
    public double f(double x) {
        return 2*Math.pow(x,3)+3*Math.pow(x,2)+3;
    }

    @Override
    public String showEquation() {
        return "2*x^3 + 3*x^2 + 3 = 0";
    }
}
