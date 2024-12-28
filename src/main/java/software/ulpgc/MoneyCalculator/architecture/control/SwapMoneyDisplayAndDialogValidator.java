package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

public class SwapMoneyDisplayAndDialogValidator {

    public static boolean validate(MoneyDialog dialog, MoneyDisplay display) {
        try {
            return notEmpty(display, dialog);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean notEmpty(MoneyDisplay display, MoneyDialog dialog) {
        displayingNull(display);
        display.getMoney();
        dialog.getMoney();
        return true;
    }

    private static void displayingNull(MoneyDisplay display) {
        if (display.getMoney() == null) throw new NumberFormatException();
    }
}
