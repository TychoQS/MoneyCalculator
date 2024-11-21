package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrenciesDialogsPane {

    private final JPanel currenciesDialogsPane;
    private final CurrenciesDialog fromCurrency;
    private final CurrenciesDialog toCurrency;
    private final List<Currency> currencies;

    public SwingCurrenciesDialogsPane(List<Currency> currencies) {
        this.currencies = currencies;
        currenciesDialogsPane = new JPanel();
        fromCurrency = new SwingCurrenciesDialog();
        toCurrency = new SwingCurrenciesDialog();
        currenciesDialogsPane.add((Component) fromCurrency);
        currenciesDialogsPane.add(exchangeButton());
        currenciesDialogsPane.add((Component) toCurrency);
    }

    private Component fromCurrencyPanel() {
        JPanel panel = new JPanel();
        panel.add((Component) fromCurrency);
        return panel;
    }

    private Component toCurrencyPanel() {
        JPanel panel = new JPanel();
        panel.add((Component) toCurrency);
        return panel;
    }
    private Component exchangeButton() {
        JButton button = new JButton("exchange");
        button.addActionListener(e -> System.out.println("EXCHANGE BUTTON MOCK IMPLEMENTATION"));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public JPanel getCurrenciesDialogsPane() {
        fromCurrency.display(currencies);
        toCurrency.display(currencies);
        return currenciesDialogsPane;
    }

    public CurrenciesDialog getFromCurrency() {
        return fromCurrency;
    }

    public CurrenciesDialog getToCurrency() {
        return toCurrency;
    }
}
