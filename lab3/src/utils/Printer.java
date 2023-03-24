package utils;


import java.util.List;

public class Printer {

    public void showAnswer(List<Double> ansL, List<Double> ansR, List<Double> ansM){
        System.out.println("\nBy the formula of the left rectangles: "+ ansL.get(1));
        System.out.println("By the formula of the middle rectangles: "+ ansM.get(1));
        System.out.println("By the formula of the right rectangles: "+ ansR.get(1)+"\n");
    }
}
