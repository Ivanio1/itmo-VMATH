package methods.interpolation;

import java.util.ArrayList;

public class SplineMethod {
    ArrayList<Double> x;
    ArrayList<Double> y;
    int n;

    public SplineMethod(ArrayList<Double> x, ArrayList<Double> y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public Spline findSpline() {
        //Find hi
        double[] arrayOfH = new double[x.size() - 1];
        for (int i = 0; i < arrayOfH.length; i++) {
            arrayOfH[i] = x.get(i+1) - x.get(i);
        }
        //Find ci by solving SLAU
        double[][] arrayOfC = getSLAU(arrayOfH, y);
        GaussMethod gaussMethod = new GaussMethod(y.size());
        double[] result = gaussMethod.getTriangular(arrayOfC);

        //Find bi
        double[] arrayOfB = new double[y.size()];
        for (int i = 1; i < arrayOfB.length; i++) {
            arrayOfB[i] = (y.get(i) - y.get(i-1)) / arrayOfH[i - 1] + arrayOfH[i - 1] * (result[i] * 2 / 3 + result[i - 1] * 2 / 6);
        }

        //Find di
        double[] arrayOfD = new double[y.size()];
        arrayOfD[0] = result[0] / arrayOfH[0];
        for (int i = 1; i < arrayOfD.length; i++){
            arrayOfD[i] = (result[i] - result[i - 1]) / (3 * arrayOfH[i - 1]);
        }

        return new Spline(this.y, arrayOfB, result, arrayOfD, this.x);
    }


    private double[][] getSLAU(double[] h, ArrayList<Double> y) {
        double[][] result = new double[y.size()][y.size() + 1];
        for (int i = 0; i < y.size(); i++) {
            for (int j = 0; j < y.size(); j++)
                result[i][j] = 0;
        }
        for (int i = 1; i < y.size() - 1; i++) {
            result[i][i - 1] = h[i - 1];
            result[i][i] = 2 * (h[i] + h[i - 1]);
            result[i][i + 1] = h[i];
            result[i][h.length + 1] = 3 * ((y.get(i+1) - y.get(i)) / h[i] - (y.get(i) - y.get(i-1)) / h[i - 1]);
        }
        result[0][0] = 1;
        result[h.length][h.length] = 1;
        result[0][h.length + 1] = 0;
        result[h.length][h.length + 1] = 0;
        return result;
    }

}
