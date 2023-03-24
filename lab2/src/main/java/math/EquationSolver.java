package math;

import math.equations.Equation;
import math.equations.FirstEquation;
import math.equations.SecondEquation;
import math.equations.ThirdEquation;
import math.methods.BisectionMethod;
import math.methods.ChordMethod;
import utils.Inputer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class EquationSolver {
    double a = 0;
    double b = 0;
    double E = 0;
    double x = 0;
    double x_half = 0;
    double x_chord = 0;

    public void solve() {
        Inputer inputer = new Inputer();
        int number = inputer.inputNumberOfEquation();
        inputBordersAndEpsilon();
        ChordMethod chordMethod = new ChordMethod(a, b, E, x, x_chord);
        BisectionMethod bisectionMethod = new BisectionMethod(a, b, E, x, x_half);
        switch (number) {
            case 1 -> {
                FirstEquation equation = new FirstEquation();
                solveEquation(equation, bisectionMethod, chordMethod);
            }
            case 2 -> {
                SecondEquation equation = new SecondEquation();
                solveEquation(equation, bisectionMethod, chordMethod);
            }
            case 3 -> {
                ThirdEquation equation = new ThirdEquation();
                solveEquation(equation, bisectionMethod, chordMethod);
            }
        }
    }

    public void solveEquation(Equation equation, BisectionMethod bisectionMethod, ChordMethod chordMethod) {
        if (equation.f(a) * equation.f(b) <= 0) {
            bisectionMethod.halfMethod(equation);
            System.out.println("The answer by the method of dividing in half: \n\tThe found answer of the equation = " + bisectionMethod.getX_half() + "\n\tNumber of iterations = " + bisectionMethod.getN() + "\n");
            chordMethod.hordMethod(equation);
            System.out.println("The answer by the chord method: \n\tThe found answer of the equation = " + chordMethod.getX_chord() + "\n\tNumber of iterations = " + chordMethod.getN() + "\n");
            compareMethods(bisectionMethod.getX_half(), chordMethod.getX_chord());
        } else {
            System.out.println("There are no solutions in this interval or number of solutions is more than one! Please change input values.");
        }
    }

    public void compareMethods(double x_half, double x_chord) {
        double difference = x_half - x_chord;
        if (difference > 0) System.out.format("The difference between the two methods: %.15f", difference);
        else System.out.format("The difference between the two methods: %.15f \n\n", (difference * -1));
    }

    public void inputBordersAndEpsilon() {
        Inputer inputer = new Inputer();
        int option = inputer.inputFileOrConsole();
        switch (option) {
            case 1 -> {
                System.out.println("The data in the file must be separated by a space and presented in the sequence a b e");
                System.out.print("Enter file name:  ");
                Scanner inn = new Scanner(System.in);
                String filename = inn.nextLine();
                try {
                    FileInputStream fstream = new FileInputStream(filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        String[] numbers = line.split(" ");
                        a = Double.parseDouble(numbers[0]);
                        b = Double.parseDouble(numbers[1]);
                        E = Double.parseDouble(numbers[2]);
                    }
                } catch (FileNotFoundException e1) {
                    System.out.println("File not found!");
                    inputBordersAndEpsilon();
                } catch (Exception e) {
                    System.out.println("Error with opening file!");
                    inputBordersAndEpsilon();
                }
            }
            case 2 -> {
                try {
                    Scanner innn = new Scanner(System.in).useLocale(Locale.US);
                    System.out.println("When entering a fractional number, separate the whole part with a dot!");
                    System.out.println("Enter the left border:");
                    a = innn.nextDouble();
                    System.out.println("Enter the right border:");
                    b = innn.nextDouble();
                    System.out.println("Enter the desired error:");
                    E = innn.nextDouble();
                } catch (Exception e) {
                    System.out.println("Error occurred! Check that separator is a dot, not comma. Try again.");
                    inputBordersAndEpsilon();
                }

            }
        }

        if (a > b) {
            double tmp = a;
            a = b;
            b = tmp;
        }
    }
}
