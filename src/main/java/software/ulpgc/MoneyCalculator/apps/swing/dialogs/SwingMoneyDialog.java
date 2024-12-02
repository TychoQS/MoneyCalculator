package software.ulpgc.MoneyCalculator.apps.swing.dialogs;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SwingMoneyDialog extends JTextField implements MoneyDialog {

    private final CurrenciesDialog currenciesDialog;
    private final String PLACEHOLDER  = "Type your amount here...";
    
    public SwingMoneyDialog(CurrenciesDialog currenciesDialog) {
        super(15);
        this.currenciesDialog = currenciesDialog;
        this.initPlaceholder();
    }

    @Override
    public Money getMoney() {
        return new Money(toDouble(this.getText()), currenciesDialog.getSelectedCurrency());
    }

    @Override
    public void setMoney(Money money) {
        this.setText(getAmount(money));
    }

    private static String getAmount(Money money) {
        return String.valueOf(money.getAmount());
    }

    private double toDouble(String amount) {
        return Double.parseDouble(amount);
    }

    private void initPlaceholder() {
        setText(PLACEHOLDER);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPlaceholderDisplayed()) setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (isDialogEmpty()) setText(PLACEHOLDER);
            }
        });
    }

    private boolean isDialogEmpty() {
        return getText().isEmpty();
    }

    private boolean isPlaceholderDisplayed() {
        return getText().equals(PLACEHOLDER);
    }
}
