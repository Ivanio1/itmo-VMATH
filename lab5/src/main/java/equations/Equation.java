package equations;

public abstract class Equation {
    public abstract double function(double x , double y);
    public abstract double exactValueFunction(double x);
    public abstract void calculateC(double x , double y);
    public abstract String toString();

}
