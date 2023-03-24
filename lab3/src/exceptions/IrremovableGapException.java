package exceptions;

public class IrremovableGapException extends Exception{
    public IrremovableGapException(double x, int number){
        super("Irremovable " + number + " kind gap in point " + x);
    }
}
