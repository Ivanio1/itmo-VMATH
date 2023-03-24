public class GaussMethod {

    private int size;
    private double[][] matrix;

    int counter = 0;

    public GaussMethod(int size, double[][] matrix) {
        this.size = size;
        this.matrix = matrix;
    }

    //Поиск минора для детерминанта
    private double[][] GetMinor(double[][] matrix, int row, int column) {
        int minorLength = matrix.length - 1;
        double[][] minor = new double[minorLength][minorLength];
        int I = 0; //переменные для пропуска ненужных строк и столбцов
        int J = 0;
        for (int i = 0; i <= minorLength; i++) {
            J = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    I = 1;
                } else {
                    if (j == column) {
                        J = 1;
                    } else {
                        minor[i - I][j - J] = matrix[i][j];
                    }
                }
            }
        }
        return minor;
    }

    //Поиск детерминанта
    public double det(double[][] matrix) {
        double Det = 0.0;
        if (matrix.length == 2) {
            Det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            int koeff = 1;
            for (int i = 0; i < matrix.length; i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }
                Det += koeff * matrix[0][i] * this.det(this.GetMinor(matrix, 0, i));
            }
        }
        return Det;
    }


    //Проверка на наличие решений
    public boolean checkIfHasSolutions() {
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


    public double[] getSolutions() {
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

    public double[] getError(double[] sol) {
        double[] err = new double[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                err[i] += matrix[i][j] * sol[j];
            }
            err[i] -= matrix[i][size];
        }
        return err;
    }


    public double[][] getTriangular() {
        double number;
        for (int i = 0; i < size - 1; i++) {
            //Если элемент на диагонали = 0, меняем строчки
            if (matrix[i][i] == 0) {
                double[] temp = matrix[i];
                matrix[i] = matrix[i + 1];
                matrix[i + 1] = temp;
                counter++;
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

            if (!checkIfHasSolutions()) {
                return null;
            }
        }
        return matrix;
    }
}