package math.systems;

public abstract class EquationSystem {
    public abstract double f1(double x, double y);

    public abstract double f2(double x, double y);

    public abstract double df1_x(double x, double y);

    public abstract double df1_y(double x, double y);

    public abstract double df2_x(double x, double y);

    public abstract double df2_y(double x, double y);
}
