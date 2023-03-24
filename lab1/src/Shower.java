public class Shower {
    public Shower() {}

    //Вывод матрицы
    String showMatrix(int size, double[][] matrix, String outputString) {
        if (matrix != null) {
            System.out.println(outputString);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size + 1; j++) {
                    System.out.format("%6.4f ", matrix[i][j]);
                    if (j == size - 1) System.out.print("|");
                }
                System.out.println();
            }
            System.out.println();
        }else{
            return "Matrix is null";
        }
        return "Nice";
    }

    //Вывод решений
    void showSolutions(int size, double[] sol) {
        System.out.println("\nSolution: ");
        for (int i = 0; i < size; i++) {
            System.out.format("x[%d] = %6.4f\n", i, sol[i]);
        }
    }

    //Вывод невязок
    void showError(int size, double[] err) {
        System.out.println("\nErrors: ");
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "] = ");
            System.out.format("%e ", err[i]);
            System.out.println();
        }
    }

}
