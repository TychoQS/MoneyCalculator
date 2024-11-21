package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrenciesDialog extends JComboBox implements CurrenciesDialog {

    public SwingCurrenciesDialog() {
        this.setPreferredSize(new Dimension(250, 30));
    }

    @Override
    public void display(List<Currency> currencies) {
        this.removeAll();
        for (Currency currency : currencies) {
            this.addItem(new Currency(currency.getCode(), currency.getName(), currency.getSymbol()) {
                @Override
                public String toString() {
                    return getName() + "(" + getCode() + " - " + getSymbol() + ")";
                }
            });
        }
    }
}
