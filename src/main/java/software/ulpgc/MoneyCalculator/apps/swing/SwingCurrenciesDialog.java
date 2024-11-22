package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.util.List;

public class SwingCurrenciesDialog extends JComboBox implements CurrenciesDialog {

    public SwingCurrenciesDialog() {
        super();
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
}
