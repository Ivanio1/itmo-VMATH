package utils;

public class Printer {

    public void UserInputChoosed(String function, boolean generateNoise){
        System.out.println("\nYou choose User Input to generate the dots. Your function is "+function+".\nNoise generation status is "+generateNoise+".");
    }

    public void GeneratedDotsChoosed(String function, boolean generateNoise){
        System.out.println("\nYou choose already generated dots. Your function is "+function+".\nNoise generation status is "+generateNoise+".");
    }
    public void finalMessage(){
        System.out.println("Check your function in opened window!");
    }
}
