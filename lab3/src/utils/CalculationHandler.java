package utils;

import exceptions.FunctionNotDefinedException;
import exceptions.IrremovableGapException;
import integrals.*;
import methods.LeftRectangleMethod;
import methods.MiddleRectangleMethod;
import methods.RightRectangleMethod;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CalculationHandler {

    double a, b, e; // пределы интегрирования, b - верхний, a - нижний, e - погрешность
    boolean flag = false; // если верхний предел меньше нижнего
    int n = 10;
    List<Double> ansLeft;
    List<Double> ansRight;
    List<Double> ansMiddle;
    RightRectangleMethod rightRectangleMethod = new RightRectangleMethod();
    LeftRectangleMethod leftRectangleMethod = new LeftRectangleMethod();
    MiddleRectangleMethod middleRectangleMethod = new MiddleRectangleMethod();

    public void startCalculation() throws IrremovableGapException, FunctionNotDefinedException {
        Inputer inputer = new Inputer();
        int option = inputer.inputNumberOfIntegral();
        Integral integral = chooseIntegral(option);



        inputBordersAndEpsilon();

        double numberOfClosing = inputer.inputWayOfClosingGap();


        ansRight = rightRectangleMethod.solve(integral, a, b, e, n,numberOfClosing);
        ansLeft = leftRectangleMethod.solve(integral, a, b, e, n,numberOfClosing);
        ansMiddle = middleRectangleMethod.solve(integral, a, b, e, n,numberOfClosing);

        if (flag) {
            ansLeft.add(1, -ansLeft.get(1));
            ansRight.add(1, -ansRight.get(1));
            ansMiddle.add(1, -ansMiddle.get(1));
        }

        Printer printer = new Printer();
        printer.showAnswer(ansLeft, ansRight, ansMiddle);
    }


    public Integral chooseIntegral(int option) {
        Integral integral = null;
        switch (option) {
            case 1 -> {
                integral = new FirstIntegral();
            }
            case 2 -> {
                integral = new SecondIntegral();
            }
            case 3 -> {
                integral = new ThirdIntegral();
            }
            case 4 -> {
                integral = new FourthIntegral();
            }
            case 5 -> {
                integral = new FifthIntegral();
            }
        }
        return integral;
    }

    public void inputBordersAndEpsilon() {
        try {
            Scanner innn = new Scanner(System.in).useLocale(Locale.US);
            System.out.println("When entering a fractional number, separate the whole part with a dot!");
            System.out.println("Enter the lower limit of integration:");
            a = innn.nextDouble();
            System.out.println("Enter the upper limit of integration:");
            b = innn.nextDouble();
            System.out.println("Enter the desired error:");
            e = innn.nextDouble();

            if (a > b) {
                flag = true;
                a = a + b - (b = a); // меняем местами значения, учтем будущий минус через флаг
            }

        } catch (Exception e) {
            System.out.println("Error occurred! Check that separator is a dot, not comma. Try again.");
            inputBordersAndEpsilon();
        }
    }
}
