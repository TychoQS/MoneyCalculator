package software.ulpgc.MoneyCalculator.architecture.view;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.util.List;

public interface CurrenciesDialog {
    void display(List<Currency> currencies);
}
