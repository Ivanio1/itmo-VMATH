package utils;

public class Printer {

    public static String printResult(int i, double x, double y, double f, double exact) {
        return String.format("i: %d \nX: %f \nY: %f \nF(x,y): %f \nExact value: %f", i, x, y, f, exact);
    }
    public void finalMessage(){
        System.out.println("Check your function in opened window!");
    }
}
