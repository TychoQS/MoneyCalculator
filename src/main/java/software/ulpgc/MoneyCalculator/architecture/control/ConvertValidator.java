package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

public class ConvertValidator {
    public static boolean validate(MoneyDialog dialog) { // TODO -> Try to refact or rethink (Extract to methods to facilitate abstraction)
        try {
            dialog.getMoney();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
