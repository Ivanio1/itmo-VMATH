package math.systems;

public class ThirdSystem extends EquationSystem {
    @Override
    public double f1(double x, double y) {
        return Math.pow(x, 2) -2*y;
    }

    @Override
    public double f2(double x, double y) {
        return  2*x + x*y -8;
    }

    @Override
    public double df1_x(double x, double y) {
        return 2*x;
    }

    @Override
    public double df1_y(double x, double y) {
        return -2;
    }

    @Override
    public double df2_x(double x, double y) {
        return 2+y;
    }

    @Override
    public double df2_y(double x, double y) {
        return x;
    }
}
