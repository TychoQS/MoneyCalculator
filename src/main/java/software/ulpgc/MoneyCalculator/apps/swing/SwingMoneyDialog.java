package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

import javax.swing.*;

public class SwingMoneyDialog extends JTextField implements MoneyDialog {

    private final CurrenciesDialog currenciesDialog;

    public SwingMoneyDialog(CurrenciesDialog currenciesDialog) {
        super();
        this.currenciesDialog = currenciesDialog;
    }

    @Override
    public Money getMoney() {
        return new Money(toDouble(this.getText()), currenciesDialog.getSelectedCurrency());
    }

    private double toDouble(String amount) {
        return Double.parseDouble(amount);
    }
}
