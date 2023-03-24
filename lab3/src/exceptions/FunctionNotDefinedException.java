package exceptions;

public class FunctionNotDefinedException extends Exception{
    public FunctionNotDefinedException(){
        super("Function not defined!");
    }
}
