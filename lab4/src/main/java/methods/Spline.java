package methods;

public class Spline {
    private double[] y;
    private double[] b;
    private double[] c;
    private double[] d;
    private double[] x;

    public Spline(double[] y, double[] b, double[] c, double[] d, double[] x) {
        this.y = y;
        this.b = b;
        this.c = c;
        this.d = d;
        this.x = x;
    }

    public double f(double x, int i) {
        double deltaX =x - this.x[i];
        return this.y[i] + this.b[i] * (deltaX) + this.c[i] * Math.pow(deltaX,2) + this.d[i] * Math.pow(deltaX,3);
    }

    public double[] getY() {
        return y;
    }

    public double[] getB() {
        return b;
    }

    public double[] getC() {
        return c;
    }

    public double[] getD() {
        return d;
    }

    public double[] getX() {
        return x;
    }
}
