package math;

import math.methods.NewtonMethod;
import math.systems.EquationSystem;
import math.systems.FirstSystem;
import math.systems.SecondSystem;
import math.systems.ThirdSystem;
import utils.Inputer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class SystemSolver {
    double E;
    double[] startValues = {0,0};

    public void solve() {
        Inputer inputer = new Inputer();
        int number = inputer.inputNumberOfSystem();
        inputSystemValues();
        switch (number) {
            case 1 -> {
                FirstSystem system = new FirstSystem();
                solveSystem(system);
            }
            case 2 -> {
                SecondSystem system = new SecondSystem();
                solveSystem(system);
            }
            case 3 -> {
                ThirdSystem system = new ThirdSystem();
                solveSystem(system);
            }
        }

    }
    public void solveSystem(EquationSystem system ){
        NewtonMethod newtonMethod = new NewtonMethod();
        newtonMethod.doMethod(system,startValues,E);
        System.out.println("The answer by the newton method: ");
        System.out.format("x = %.6f",newtonMethod.getRoots()[0]);
        System.out.format(" y = %.6f\n",newtonMethod.getRoots()[1]);
        System.out.println("Number of iterations = " + newtonMethod.getN()+"\n");
    }

    public void inputSystemValues() {
        Inputer inputer = new Inputer();
        int option = inputer.inputFileOrConsole();
        switch (option) {
            case 1 -> {
                System.out.println("The data in the file must be separated by a space and presented in the sequence x0 y0 e");
                System.out.print("Enter file name:  ");
                Scanner inn = new Scanner(System.in);
                String filename = inn.nextLine();
                try {
                    FileInputStream fstream = new FileInputStream(filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        String[] numbers = line.split(" ");
                        startValues[0] = Double.parseDouble(numbers[0]);
                        startValues[1] = Double.parseDouble(numbers[1]);
                        E = Double.parseDouble(numbers[2]);
                    }
                } catch (FileNotFoundException e1) {
                    System.out.println("File not found!");
                    inputSystemValues();
                } catch (Exception e) {
                    System.out.println("Error with opening file!");
                    inputSystemValues();
                }
            }
            case 2 -> {
                try {
                    Scanner innn = new Scanner(System.in).useLocale(Locale.US);
                    System.out.println("When entering a fractional number, separate the whole part with a dot!");
                    System.out.println("Enter the initial approximation (x):");
                    startValues[0] = innn.nextDouble();
                    System.out.println("Enter the initial approximation (y):");
                    startValues[1] = innn.nextDouble();
                    System.out.println("Enter the desired error:");
                    E = innn.nextDouble();
                } catch (Exception e) {
                    System.out.println("Error occurred! Check that separator is a dot, not comma. Try again.");
                    inputSystemValues();
                }

            }
        }
    }
}
