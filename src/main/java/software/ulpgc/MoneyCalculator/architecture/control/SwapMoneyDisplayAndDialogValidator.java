package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

public class SwapMoneyDisplayAndDialogValidator { // TODO -> Try to refact or rethink (Extract to methods to facilitate abstraction)

    public static boolean validate(MoneyDialog dialog, MoneyDisplay display) {
        try {
            dialog.getMoney();
            display.getMoney();
            if (display.getMoney() == null) throw new NumberFormatException();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
