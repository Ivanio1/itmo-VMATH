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

    public int inputNumberOfIntegral() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12345]")) {
            System.out.print("\nWhat integral do you want to solve: \n 1: (x^2+1)/2\n 2: x^3+2x^2-x+1 \n 3: sin(x+1) \n 4: 1/x \n 5: sin(x)/x \n Choose option: ");
            input = in.nextLine();
        }
        return Integer.parseInt(input);
    }

    public double inputWayOfClosingGap() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("[12]")) {
            System.out.print("\nIf there is a removable gap in the interval, how to close the it: \n 1 - (f(x-e)+f(x+e))/2\n 2 - Choose the number to close the gap\n Choose option: ");
            input = in.nextLine();
            if(Integer.parseInt(input)==2){
                return inputValue();
            }
        }
        return Double.parseDouble(input);
    }

    public double inputValue() {
        String input = "";
        Scanner in = new Scanner(System.in);
        while (!input.matches("^-?\\d+$")) {
            System.out.print("\nChoose number to close the gap: ");
            input = in.nextLine();
        }
        return Double.parseDouble(input);
    }

}
