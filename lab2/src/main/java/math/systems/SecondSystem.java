package math.systems;

public class SecondSystem extends EquationSystem {
    @Override
    public double f1(double x, double y) {
        return 2 * x - Math.sin(y - 0.5) - 1;
    }

    @Override
    public double f2(double x, double y) {
        return Math.cos(x) + y - 1.5;
    }

    @Override
    public double df1_x(double x, double y) {
        return 2;
    }

    @Override
    public double df1_y(double x, double y) {
        return -Math.cos(y - 0.5);
    }

    @Override
    public double df2_x(double x, double y) {
        return -Math.sin(x);
    }

    @Override
    public double df2_y(double x, double y) {
        return 1;
    }
}
