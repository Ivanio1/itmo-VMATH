package methods;



import java.util.ArrayList;

public class TableOfDots {
    private ArrayList<Double> xs, ys;

    public TableOfDots(ArrayList<Double> xs, ArrayList<Double> ys) {
        this.xs = xs;
        this.ys = ys;
    }

    public ArrayList<Double> getXs() {
        return xs;
    }

    public ArrayList<Double> getYs() {
        return ys;
    }

    public void setXs(ArrayList<Double> xs) {
        this.xs = xs;
    }

    public void setYs(ArrayList<Double> ys) {
        this.ys = ys;
    }
}
