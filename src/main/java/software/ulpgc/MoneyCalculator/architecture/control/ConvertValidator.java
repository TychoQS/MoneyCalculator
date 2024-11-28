package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

public class ConvertValidator {
    public static boolean validate(MoneyDialog dialog) { // TODO -> Try to rethink implementation
        try {
            return notEmpty(dialog);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean notEmpty(MoneyDialog dialog) {
        dialog.getMoney();
        return true;
    }
}
