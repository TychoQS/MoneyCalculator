package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingMoneyDialog;
import software.ulpgc.MoneyCalculator.apps.swing.displays.SwingMoneyDisplay;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SwingConversionPane {

    private final JPanel conversionPane;
    private final Map<String, Command> commands;
    private final CurrenciesDialog fromCurrenciesDialog;
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;

    public SwingConversionPane(Map<String, Command> commands, CurrenciesDialog fromCurrenciesDialog) {
        this.commands = commands;
        this.fromCurrenciesDialog = fromCurrenciesDialog;
        conversionPane = new JPanel();
        conversionPane.add(moneyDialog());
        conversionPane.add(convertButton());
        conversionPane.add(moneyDisplay());
    }

    private Component moneyDialog() {
        moneyDialog = new SwingMoneyDialog(fromCurrenciesDialog);
        return (Component) moneyDialog;
    }

    private Component convertButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(e -> commands.get("convert").execute());
        return button;
    }

    private Component moneyDisplay() {
        this.moneyDisplay = new SwingMoneyDisplay();
        return (Component) moneyDisplay;
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
