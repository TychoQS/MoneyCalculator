package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

import java.io.IOException;

public class ConversorValidator {
    public static boolean validate(MoneyDialog dialog) {
        try {
            dialog.getMoney();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
