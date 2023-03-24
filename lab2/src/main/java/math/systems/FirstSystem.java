package math.systems;

public class FirstSystem extends EquationSystem {
    @Override
    public double f1(double x, double y) {
        return 2*Math.pow(x,2)+3*Math.pow(y-1,2)-7;
    }

    @Override
    public double f2(double x, double y) {
        return Math.pow(x+2,2) + 3*Math.pow(y,2)-6;
    }

    @Override
    public double df1_x(double x, double y) {
        return 4*x;
    }

    @Override
    public double df1_y(double x, double y) {
        return 6*y-6;
    }

    @Override
    public double df2_x(double x, double y) {
        return 2*x+4;
    }

    @Override
    public double df2_y(double x, double y) {
        return 6*y;
    }
}
