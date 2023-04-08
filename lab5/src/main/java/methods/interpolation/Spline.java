package methods.interpolation;

import java.util.ArrayList;

public class Spline {
    private ArrayList<Double> y;
    private double[] b;
    private double[] c;
    private double[] d;
    private ArrayList<Double> x;

    public Spline(ArrayList<Double> y, double[] b, double[] c, double[] d, ArrayList<Double> x) {
        this.y = y;
        this.b = b;
        this.c = c;
        this.d = d;
        this.x = x;
    }

    public double f(double x, int i) {
        double deltaX =x - this.x.get(i);
        return this.y.get(i) + this.b[i] * (deltaX) + this.c[i] * Math.pow(deltaX,2) + this.d[i] * Math.pow(deltaX,3);
    }

    public ArrayList<Double> getY() {
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

    public ArrayList<Double> getX() {
        return x;
    }
}
