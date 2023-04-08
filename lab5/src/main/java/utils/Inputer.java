package utils;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class Inputer {

    public int inputMenu() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nMenu: \n 1 - Start calculation\n 2 - Exit\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public int inputEquation() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nChoose equation: \n 1: y' = x * y\n 2: y' = sin(x) + y\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public double inputStep() throws Exception {
        double x = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter h. Comma is a separator of float.");
        x = in.nextDouble();
        if (x <= 0) throw new Exception("Error");
        return x;
    }

    public double inputEpsilon() throws Exception {
        double x = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter epsilon. Comma is a separator of float.");
        x = in.nextDouble();
        if (x <= 0) throw new Exception("Error");
        return x;
    }

    public double inputLeftBorder() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("^-?\\d+$")) {
            System.out.print("\nEnter the left border: ");
            input = in.nextLine();
        }
        return Double.parseDouble(input);
    }
    public double inputRightBorder() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("^-?\\d+$")) {
            System.out.print("\nEnter the right border: ");
            input = in.nextLine();
        }
        return Double.parseDouble(input);
    }

    public double inputStartCondition(double a) {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("^-?\\d+$")) {
            System.out.printf("\nEnter starting condition y(%s): ",a);
            input = in.nextLine();
        }
        return Double.parseDouble(input);
    }

}
