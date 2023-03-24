import utils.CalculationHandler;
import utils.Inputer;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        Inputer inputer = new Inputer();
        System.out.println("""
                *********************************************
                * Welcome to Solver of definite integrals!  *
                *           Rectangle Method                *
                *********************************************
                """);



        while (true) {
            try {
                option = inputer.inputMenu();
                switch (option) {
                    case 1 -> {
                        CalculationHandler calculationHandler = new CalculationHandler();
                        calculationHandler.startCalculation();
                    }
                    case 2 -> {
                        System.out.println("Bye bye!");
                        System.exit(1);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
