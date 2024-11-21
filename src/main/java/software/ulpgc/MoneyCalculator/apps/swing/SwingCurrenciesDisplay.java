package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDisplay;
import software.ulpgc.MoneyCalculator.architecture.view.CurrencyDisplay;

import javax.swing.*;
import java.util.List;

public class SwingCurrenciesDisplay extends JComboBox implements CurrenciesDisplay {

    public SwingCurrenciesDisplay() {}

    @Override
    public void display(List<Currency> currencies) {
        this.removeAll();
        for (Currency currency : currencies) {
            this.addItem(new Currency(currency.getName(), currency.getCode(), currency.getSymbol()) {
                @Override
                public String toString() {
                    return getName() + "(" + getCode() + " - " + getSymbol() + ")";
                }
            });
        }
    }
}
