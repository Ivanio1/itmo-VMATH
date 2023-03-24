package math.methods;

import math.systems.EquationSystem;

import java.util.Arrays;

public class NewtonMethod {
    double[] roots = new double[2];
    int n=0;

    public void doMethod(EquationSystem system, double[] startValues, double E) {
        n=0;
        roots[0] = system.f1(startValues[0], startValues[1]);
        roots[1] = system.f2(startValues[0], startValues[1]);
        double[] prev_roots = {roots[0] + 2 * E, roots[1] + 2 * E}; //+2 чтобы войти в цикл
        double[][] matrix = new double[2][3];
        double[] deltas;
        GaussMethod gauss = new GaussMethod();
        while(Math.abs(roots[0] - prev_roots[0]) > E && Math.abs(roots[1] - prev_roots[1]) > E) {
            prev_roots = Arrays.copyOf(roots, roots.length);
            matrix[0][0] = system.df1_x(roots[0], roots[1]);
            matrix[0][1] = system.df1_y(roots[0], roots[1]);
            matrix[1][0] = system.df2_x(roots[0], roots[1]);
            matrix[1][1] = system.df2_y(roots[0], roots[1]);
            matrix[0][2] = -system.f1(roots[0], roots[1]);
            matrix[1][2] = -system.f2(roots[0], roots[1]);
            deltas = gauss.getTriangular(matrix);
            roots[0] += deltas[0];
            roots[1] += deltas[1];
            n++;
        }
    }

    public int getN() {
        return n;
    }

    public double[] getRoots() {
        return roots;
    }
}
