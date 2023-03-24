package functions;

public class FirstFunction extends Function{
    @Override
    public double f(double x) {
        return Math.pow(x,2)+2;
    }

    @Override
    public String toString() {
        return "x^2+2";
    }
}
