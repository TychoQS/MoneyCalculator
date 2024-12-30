package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingCurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SwingCurrenciesDialogsPane {

    public static final ImageIcon BUTTON_ICON = new ImageIcon(Objects.requireNonNull(SwingCurrenciesDialogsPane.class.getResource("/exchange_arrows.png")));
    public static final String EXCHANGE_COMMAND = "exchange";
    private final JPanel currenciesDialogsPane;
    private final CurrenciesDialog fromCurrency;
    private final CurrenciesDialog toCurrency;
    private final List<Currency> currencies;
    private final Map<String, Command> commands;

    public SwingCurrenciesDialogsPane(List<Currency> currencies, Map<String, Command> commands) {
        this.currencies = currencies;
        this.commands = commands;
        currenciesDialogsPane = new JPanel();
        fromCurrency = new SwingCurrenciesDialog();
        toCurrency = new SwingCurrenciesDialog();
        currenciesDialogsPane.add(fromCurrencyPanel());
        currenciesDialogsPane.add(exchangeButton());
        currenciesDialogsPane.add(toCurrencyPanel());
    }

    private Component fromCurrencyPanel() {
        JPanel panel = new JPanel();
        panel.add((Component) fromCurrency);
        return panel;
    }

    private Component exchangeButton() {
        JButton button = new JButton();
        button.setIcon(BUTTON_ICON);
        button.addActionListener(e -> commands.get(EXCHANGE_COMMAND).execute());
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private Component toCurrencyPanel() {
        JPanel panel = new JPanel();
        panel.add((Component) toCurrency);
        return panel;
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
