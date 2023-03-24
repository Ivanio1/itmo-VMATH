package math.equations;

public class ThirdEquation extends Equation{
    @Override
    public double f(double x) {
        return Math.atan(3*x) -Math.pow(x,2)+2;
    }

    @Override
    public String showEquation() {
        return "atan(3*x) - x^2 + 2 = 0";
    }
}
