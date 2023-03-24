import utils.CalculationHandler;
import utils.Inputer;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        Inputer inputer = new Inputer();
        System.out.println("""
                *********************************************
                * Welcome to Solver of nonlinear equations! *
                *********************************************
                """);


        while (true) {
            option = inputer.inputMenu();
            switch (option) {
                case 1 -> {
                    CalculationHandler calculationHandler = new CalculationHandler(inputer);
                    calculationHandler.systemOrEquation();
                }
                case 2 -> {
                    System.out.println("Bye bye!");
                    System.exit(1);
                }
            }
        }

    }
}
