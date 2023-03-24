package math.equations;

public class SecondEquation extends Equation {

    @Override
    public double f(double x) {
        return 3*x + Math.cos(x);
    }



    @Override
    public String showEquation() {
        return("3*x + cos(x) = 0");
    }
}
