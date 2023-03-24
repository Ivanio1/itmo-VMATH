package methods;

public class SplineMethod {
    double[] x;
    double[] y;
    int n;

    public SplineMethod(double[] x, double[] y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public Spline findSpline() {
        //Find hi
        double[] arrayOfH = new double[x.length - 1];
        for (int i = 0; i < arrayOfH.length; i++) {
            arrayOfH[i] = x[i + 1] - x[i];
        }
        //Find ci by solving SLAU
        double[][] arrayOfC = getSLAU(arrayOfH, y);
        GaussMethod gaussMethod = new GaussMethod(y.length);
        double[] result = gaussMethod.getTriangular(arrayOfC);

        //Find bi
        double[] arrayOfB = new double[y.length];
        for (int i = 1; i < arrayOfB.length; i++) {
            arrayOfB[i] = (y[i] - y[i - 1]) / arrayOfH[i - 1] + arrayOfH[i - 1] * (result[i] * 2 / 3 + result[i - 1] * 2 / 6);
        }

        //Find di
        double[] arrayOfD = new double[y.length];
        arrayOfD[0] = result[0] / arrayOfH[0];
        for (int i = 1; i < arrayOfD.length; i++){
            arrayOfD[i] = (result[i] - result[i - 1]) / (3 * arrayOfH[i - 1]);
        }

        return new Spline(this.y, arrayOfB, result, arrayOfD, this.x);
    }


    private double[][] getSLAU(double[] h, double[] y) {
        double[][] result = new double[y.length][y.length + 1];
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y.length; j++)
                result[i][j] = 0;
        }
        for (int i = 1; i < y.length - 1; i++) {
            result[i][i - 1] = h[i - 1];
            result[i][i] = 2 * (h[i] + h[i - 1]);
            result[i][i + 1] = h[i];
            result[i][h.length + 1] = 3 * ((y[i + 1] - y[i]) / h[i] - (y[i] - y[i - 1]) / h[i - 1]);
        }
        result[0][0] = 1;
        result[h.length][h.length] = 1;
        result[0][h.length + 1] = 0;
        result[h.length][h.length + 1] = 0;
        return result;
    }

}
