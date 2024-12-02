package software.ulpgc.MoneyCalculator.apps.swing.dialogs;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrenciesDialog extends JComboBox implements CurrenciesDialog {

    public static final Font FONT = new Font("FB Agent", Font.PLAIN, 15);

    public SwingCurrenciesDialog() {
        super();
        this.setFont(FONT);
    }

    @Override
    public void display(List<Currency> currencies) {
        for (Currency currency : currencies) {
            this.addItem(new Currency(currency.getCode(), currency.getName(), currency.getSymbol()) {
                @Override
                public String toString() {
                    return getName() + "(" + getCode() + " - " + getSymbol() + ")";
                }
            });
        }
    }

    @Override
    public Currency getSelectedCurrency() {
        return (Currency) this.getSelectedItem();
    }

    @Override
    public void setCurrency(Currency currency) {
        this.setSelectedItem(currency);
    }
}
