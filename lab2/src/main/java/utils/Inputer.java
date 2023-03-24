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

    public int inputSystemOrEquation() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nWhat do you want to solve: \n 1 - Nonlinear equation\n 2 - System of nonlinear equations\n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public int inputNumberOfEquation() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[123]")) {
            System.out.print("\nWhat equation you want to solve: \n 1: 2*x^3 + 3*x^2 + 3 = 0\n 2: 3*x + cos(x) = 0 \n 3: atan(3*x) - x^2 + 2 = 0 \n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public int inputFileOrConsole() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nChoose option for input: \n 1 - File\n 2 - Console \n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public int inputNumberOfSystem() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[123]")) {
            System.out.print("\nWhat equation you want to solve: \n 1: 2x^2+3(y-1)^2=7\n\t(x+2)^2+3y^2=6  \n 2: 2x-sin(y-0.5)=1\n\tcos(x)+y=1.5 \n 3: x^2-2y=0 \n\t2x+xy=8 \n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }
}
