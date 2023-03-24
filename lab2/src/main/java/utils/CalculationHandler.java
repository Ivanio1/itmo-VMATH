package utils;

import math.EquationSolver;
import math.SystemSolver;

public class CalculationHandler {
    private Inputer inputer;
    EquationSolver equationSolver = new EquationSolver();
    SystemSolver systemSolver = new SystemSolver();

    public CalculationHandler(Inputer inputer){
        this.inputer=inputer;
    }
    public void systemOrEquation(){
       int option = inputer.inputSystemOrEquation();
        switch (option) {
            case 1 -> {
               equationSolver.solve();
            }
            case 2 -> {
               systemSolver.solve();
            }

        }
    }
}
