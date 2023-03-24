import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 0;
        int size = 0;
        double[][] matrix = null;

        Inputer inputer = new Inputer();
        Shower shower = new Shower();
        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Menu: \n 1 - Input matrix\n 2 - Test\n 3 - Exit\n Choose option: ");
            try {
                a = in.nextInt();
            } catch (Exception e) {
                System.out.println("Enter a number 1, 2, 3!!!");
                main(args);
            }

        } while (!String.valueOf(a).matches("[123]"));

        switch (a) {
            case 1 -> {
                size = inputer.inputSize();
                matrix = inputer.inputMatrix(size);
            }
            case 2 -> {
                size = 3;
                matrix = inputer.matrixFromFile(size, "test.txt");

            }
            case 3 -> {
                System.out.println("Bye bye!");
                System.exit(1);
            }

        }

        shower.showMatrix(size, matrix, "\nMatrix:");
        GaussMethod Count = new GaussMethod(size, matrix);
        double det1 = Count.det(matrix);

        if (Count.checkIfHasSolutions()) {
            long startTime = System.nanoTime();
            double[][] Triangmatrix = Count.getTriangular();
            for (int i = 0; i < size; i++) {
                int counter = 0;
                for (int j = 0; j < size + 1; j++) {
                    if (Triangmatrix[i][j] == 0) {
                        counter++;
                    }
                }
                if (counter == size + 1) {
                    shower.showMatrix(size, Triangmatrix, "\nTriangular: ");
                    System.out.println("An infinite number of solutions");
                    System.exit(1);
                }
            }

            double elatedTime = Double.parseDouble(String.valueOf(System.nanoTime() - startTime).substring(0, 3));
            String answer = shower.showMatrix(size, Triangmatrix, "\nTriangular: ");
            if (Objects.equals(answer, "Nice")) {
                System.out.println("\nExecution Time: " + elatedTime + " ns");
                shower.showSolutions(size, Count.getSolutions());
                shower.showError(size, Count.getError(Count.getSolutions()));
                System.out.println("\nDeterminant of matrix = " + det1);
                System.out.println("\nDeterminant of triangle matrix = " + Count.det(matrix));
                System.exit(1);
            } else {
                System.out.println("There is no solution");
                System.exit(1);
            }

        } else {
            System.out.println("There is no solution");
        }


    }

}