package math.methods;

public class GaussMethod {
    int size = 2;
    public boolean areThereSolutions(double[][] matrix) {
        boolean f = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0) {
                    f = false;
                }
            }
            if (f) {
                if (matrix[i][size] != 0) return false;
            }
            f = true;
        }
        return true;
    }


    public double[] getSolutions(double[][] matrix) {

        double[] sol = new double[size];
        double b = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (i == size - 1) {
                if (matrix[i][size - 1] != 0) {
                    sol[i] = matrix[i][size] / matrix[i][size - 1];
                } else sol[i] = 0;
            } else {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j] != 0) {
                        for (int k = j + 1; k < size; k++)
                            b += (matrix[i][k] * sol[k]);
                        sol[i] = (matrix[i][size] - b) / matrix[i][j];
                        break;
                    }
                }
                b = 0;
            }
        }
        return sol;
    }


    public double[] getTriangular(double[][] matrix) {
        double number;
        for (int i = 0; i < size - 1; i++) {
            if (matrix[i][i] == 0) {
                double[] temp = matrix[i];
                matrix[i] = matrix[i + 1];
                matrix[i + 1] = temp;

            }
        }
        for (int k = 0; k < size - 1; k++) {
            number = matrix[k][k];
            if ((k != 0) && (number == 0)) {
                continue;
            }
            for (int i = 0; i < size + 1; i++) {
                matrix[k][i] /= number;
            }
            for (int i = k + 1; i < size; i++) {
                number = matrix[i][k];
                for (int j = 0; j < size + 1; j++) {
                    matrix[i][j] -= matrix[k][j] * number;

                }
            }

            if (!areThereSolutions(matrix)) {
                return null;
            }
        }
        return getSolutions(matrix);
    }
}
