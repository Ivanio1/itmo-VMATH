import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Inputer {
    public Inputer() {
    }

    //Ввод матрицы из файла
    double[][] matrixFromFile(int size, String filename) {
        double[][] matrix = new double[size][size + 1];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 0; j++) {
                matrix[i][j] = 0;
            }
        }
        try {
            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            int lineCount = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (int j = 0; j < size + 1; j++) {
                    matrix[lineCount][j] = Double.parseDouble(numbers[j]);
                }
                lineCount++;
            }
        } catch (Exception e) {
            System.out.println("ERROR. CHECK SIZE, MATRIX VALUES, FILE NAME AND TRY AGAIN");
            System.exit(1);
        }

        return matrix;
    }

    //Ввод размера
    int inputSize() {
        boolean flag = true;
        int size = 0;
        while (flag) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Input size: ");
                size = in.nextInt();
                if (size < 0 || size > 20) {
                    throw new Exception();
                }
                flag = false;

            } catch (Exception e) {
                System.out.println("Size must be a positive number! 0<size<=20");
            }
        }
        return size;
    }

    double[][] generateRandom(int size) {
        double[][] matrix = new double[size][size + 1];
        System.out.println("Generating...");
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size + 1; j++) {
                    matrix[i][j] = getRandomNumber(0, 10);
                }
            }
        } catch (Exception e) {
            System.out.println("\nElement must be a number! Comma is a separator of float");
            this.generateRandom(size);
        }
        return matrix;
    }

    public static double getRandomNumber(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    void inputKeyBoardMatrix(int size, double[][] matrix) {
        System.out.println("Input values: ");
        Scanner inn = new Scanner(System.in);
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size + 1; j++) {
                    System.out.print("matrix[" + i + "][" + j + "] = ");
                    matrix[i][j] = inn.nextDouble();

                }
            }
        } catch (Exception e) {
            System.out.println("\nElement must be a number! Comma is a separator of float");
            this.inputKeyBoardMatrix(size, matrix);
        }

    }

    //Ввод матрицы
    double[][] inputMatrix(int size) {
        Scanner in = new Scanner(System.in);
        double[][] matrix = new double[size][size + 1];
        int a = 0;
        boolean flag = true;
        while (flag) {
            System.out.print("\nHow to input matrix values?\n 1 - Keyboard input\n 2 - From file\n 3 - Generate random\nChoose option: ");
            String inning = in.nextLine();
            if (inning.matches("[123]")) {
                a = Integer.parseInt(inning);
                flag = false;
            }
        }

        switch (a) {
            case 1 -> {
                inputKeyBoardMatrix(size, matrix);
            }
            case 2 -> {
                System.out.print("Input file name: ");
                Scanner innn = new Scanner(System.in);
                String filename = innn.nextLine();
                matrix = matrixFromFile(size, filename);

            }
            case 3 -> {
                matrix = generateRandom(size);
            }
        }
        return matrix;
    }
}
