package utils;

import java.util.Scanner;

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

    public int inputFunction() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[123]")) {
            System.out.print("\nInput the number of function: \n 1 - x^2+2\n 2 - e^x\n 3 - cos(x)\nChoose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public int inputWayOfSettingDots() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nHow do you want to set the dots: \n 1 - User input\n 2 - Choose generated dots\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public int inputInfoAboutNoise() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nDo you want to generate noise?: \n 1 - Yes\n 2 - No\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }
    public int inputNumberOfDots() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("^-?\\d+$")) {
            System.out.print("\nEnter the number of dots: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public double[] inputXValues(int n) {
        double[] x = new double[n];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x values. Comma is a separator of float.");
            for (int i = 0; i < n; i++) {
                x[i] = in.nextDouble();
            }
        return x;
    }

    public int inputFirstGeneratedDots() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nChoose generated dots: \n 1 - [(1,3),(3,11),(5,27)]\n 2 - [(-2,6),(-1,3),(0,2),(1,3),(2,6)]\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }
    public int inputSecondGeneratedDots() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nChoose generated dots: \n 1 - [(0,1),(1,2.7),(2,7.38)]\n 2 - [(-5,0.007),(-2,0.14),(0,1),(1,2.7),(5,148.4)]\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }
    public int inputThirdGeneratedDots() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nChoose generated dots: \n 1 - [(1,0.54),(2,-0.41),(3,-0.98)]\n 2 - [(-1,0.54),(0,1),(1,0.54)]\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }
}
