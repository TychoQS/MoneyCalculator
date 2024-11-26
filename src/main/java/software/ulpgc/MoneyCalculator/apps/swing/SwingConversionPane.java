package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.control.Command;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class SwingConversionPane {

    public static final int FONT_SIZE = 15;
    private final JPanel conversionPane;
    private final Map<String, Command> commands;
    private final CurrenciesDialog fromCurrenciesDialog;
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;

    public SwingConversionPane(Map<String, Command> commands, CurrenciesDialog fromCurrenciesDialog) {
        this.commands = commands;
        this.fromCurrenciesDialog = fromCurrenciesDialog;
        conversionPane = new JPanel();
        conversionPane.add(introduceAmountLabel());
        conversionPane.add(moneyDialog());
        conversionPane.add(convertButton());
        conversionPane.add(moneyDisplay());
    }

    private Component moneyDisplay() {
        this.moneyDisplay = new SwingMoneyDisplay();
        return (Component) moneyDisplay;
    }

    private Component convertButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(e -> {
            try {
                commands.get("convert").execute();
            } catch (IOException ex) {
                new SwingErrorDialog("Alert", ex.getMessage());}
        });
        return button;
    }

    private Component moneyDialog() {
        moneyDialog = new SwingMoneyDialog(fromCurrenciesDialog);
        return (Component) moneyDialog;
    }

    private Component introduceAmountLabel() {
        JLabel label = new JLabel("Introduce money amount: ");
        label.setFont(getLabelFont());
        return label;
    }

    private Font getLabelFont() {
        return new Font("Montserrat", Font.BOLD, FONT_SIZE);
    }

    protected JPanel getConversionPane() {
        return conversionPane;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
}
