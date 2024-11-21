package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrenciesDialogsPane {

    private final JPanel pane;
    private final CurrenciesDialog fromCurrency;
    private final CurrenciesDialog toCurrency;
    private final List<Currency> currencies;

    public SwingCurrenciesDialogsPane(List<Currency> currencies) {
        this.currencies = currencies;
        pane = new JPanel();
        fromCurrency = new SwingCurrenciesDialog();
        toCurrency = new SwingCurrenciesDialog();
        pane.add((Component) fromCurrency);
        pane.add(exchangeButton());
        pane.add((Component) toCurrency);
        // TODO -> Probar con BorderLayoutRecursivos
        // TODO -> Probar con BoxLayout X_AXIS y que cada componente tenga su propio panel
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

    public JPanel create() {
        fromCurrency.display(currencies);
        toCurrency.display(currencies);
        return pane;
    }
}
