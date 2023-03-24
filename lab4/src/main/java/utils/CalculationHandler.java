package utils;

import functions.FirstFunction;
import functions.Function;
import functions.SecondFunction;
import functions.ThirdFunction;
import methods.Spline;
import methods.SplineMethod;

import java.util.Random;

public class CalculationHandler {

    public void startCalculation() {
        int optionOfFunction, optionOfSettingDots;
        double[] x = new double[0];
        double[] y = new double[0];
        Random random = new Random();
        
        Inputer inputer = new Inputer();
        Printer printer = new Printer();
        SplineMethod splineMethod = null;
        optionOfFunction = inputer.inputFunction();
        boolean generateNoise = getNoiseInfo();
        Function function = getFunctionByNumber(optionOfFunction);
        optionOfSettingDots = inputer.inputWayOfSettingDots();

        //Entering the dots
        switch (optionOfSettingDots) {
            case 1 -> {
                printer.UserInputChoosed(function.toString(), generateNoise);
                int n = inputer.inputNumberOfDots();
                x = inputer.inputXValues(n);
                y = new double[n];
                if (!generateNoise)
                    for (int i = 0; i < n; i++) {
                        y[i] = function.f(x[i]);
                    }
                else for (int i = 0; i < n; i++) {
                    y[i] = function.f(x[i]) + random.nextDouble() * 0.1;
                }
                splineMethod = new SplineMethod(x,y,n);
            }
            case 2 -> {
                printer.GeneratedDotsChoosed(function.toString(), generateNoise);
                if (optionOfFunction == 1) {
                    int option = inputer.inputFirstGeneratedDots();
                    switch (option) {
                        case 1 -> {
                            x = new double[]{1, 3, 5};
                            if (!generateNoise) {
                                y = new double[]{3, 11, 27};
                            } else {
                                y = new double[]{3 + random.nextDouble() * 0.1, 11 + random.nextDouble() * 0.1, 27 + random.nextDouble() * 0.1};
                            }
                        }
                        case 2 -> {
                            x = new double[]{-2, -1, 0, 1, 2};
                            if (!generateNoise) {
                                y = new double[]{6, 3, 2, 3, 6};
                            } else {
                                y = new double[]{6 + random.nextDouble() * 0.1, 3 + random.nextDouble() * 0.1, 2 + random.nextDouble() * 0.1, 3 + random.nextDouble() * 0.1, 6 + random.nextDouble() * 0.1};
                            }
                        }
                    }
                } else if (optionOfFunction == 2) {
                    int option = inputer.inputSecondGeneratedDots();
                    switch (option) {
                        case 1 -> {
                            x = new double[]{0, 1, 2};
                            if (!generateNoise) {
                                y = new double[]{1, 2.7, 7.38};
                            } else {
                                y = new double[]{1 + random.nextDouble() * 0.1, 2.7 + random.nextDouble() * 0.1, 7.38 + random.nextDouble() * 0.1};
                            }
                        }
                        case 2 -> {
                            x = new double[]{-5, -2, 0, 1, 5};
                            if (!generateNoise) {
                                y = new double[]{0.007, 0.14, 1, 2.7, 148.4};
                            } else {
                                y = new double[]{0.007 + random.nextDouble() * 0.1, 0.14 + random.nextDouble() * 0.1, 1 + random.nextDouble() * 0.1, 2.7 + random.nextDouble() * 0.1, 148.4 + random.nextDouble() * 0.1};
                            }
                        }
                    }
                } else if (optionOfFunction == 3) {
                    int option = inputer.inputThirdGeneratedDots();
                    switch (option) {
                        case 1 -> {
                            x = new double[]{1, 2, 3};
                            if (!generateNoise) {
                                y = new double[]{0.54, -0.41, -0.98};
                            } else {
                                y = new double[]{0.54 + random.nextDouble() * 0.1, -0.41 + random.nextDouble() * 0.1, -0.98 + random.nextDouble() * 0.1};
                            }
                        }
                        case 2 -> {
                            x = new double[]{-1, 0, 1};
                            if (!generateNoise) {
                                y = new double[]{0.54, 1, 0.54};
                            } else {
                                y = new double[]{0.54 + random.nextDouble() * 0.1, 1+ random.nextDouble() * 0.1, 0.54 + random.nextDouble() * 0.1};
                            }
                        }
                    }
                }
                splineMethod = new SplineMethod(x,y,y.length);

            }
        }
        
        Spline spline = splineMethod.findSpline();
        Graphic graph = new Graphic(spline, function.toString());
        printer.finalMessage();
        graph.drawGraph(function);
    }

    public Function getFunctionByNumber(int number) {
        Function function = null;
        switch (number) {
            case 1 -> {
                function = new FirstFunction();
            }
            case 2 -> {
                function = new SecondFunction();
            }
            case 3 -> {
                function = new ThirdFunction();
            }
        }
        return function;
    }

    public boolean getNoiseInfo() {
        Inputer inputer = new Inputer();

        int number = inputer.inputInfoAboutNoise();
        switch (number) {
            case 1 -> {
                return true;
            }
            case 2 -> {
                return false;
            }

        }
        return false;
    }
}
