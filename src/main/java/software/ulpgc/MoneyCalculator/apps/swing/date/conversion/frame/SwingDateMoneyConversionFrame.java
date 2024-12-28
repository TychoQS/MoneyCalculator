package software.ulpgc.MoneyCalculator.apps.swing.date.conversion.frame;

import software.ulpgc.MoneyCalculator.apps.swing.mainframe.displays.SwingMoneyDisplay;
import software.ulpgc.MoneyCalculator.apps.swing.mainframe.dialogs.SwingCurrenciesDialog;
import software.ulpgc.MoneyCalculator.apps.swing.mainframe.dialogs.SwingMoneyDialog;
import software.ulpgc.MoneyCalculator.apps.swing.date.conversion.dialogs.SwingDateDialog;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingDateMoneyConversionFrame extends JFrame {

    private final Map<String, Command> commands;
    private CurrenciesDialog fromCurrenciesDialog;
    private CurrenciesDialog toCurrenciesDialog;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private DateDialog dateDialog;

    public SwingDateMoneyConversionFrame(List<Currency> currencies) throws HeadlessException {
        this.commands = new HashMap<>();
        initFrame();
        this.add(BorderLayout.NORTH, northPane(currencies));
        this.add(BorderLayout.CENTER, centerPane());
    }

    private Component centerPane() {
        JPanel centerPane = new JPanel();
        moneyDialog = new SwingMoneyDialog(this.fromCurrenciesDialog);
        moneyDisplay = new SwingMoneyDisplay();
        centerPane.add((Component) moneyDialog);
        centerPane.add(dateDialog());
        centerPane.add(convertButton());
        centerPane.add((Component) moneyDisplay);
        return centerPane;
    }
    private Component dateDialog() {
        this.dateDialog = new SwingDateDialog();
        return (Component) dateDialog;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }

    private void initFrame() {
        this.setTitle("Date conversion");
        this.setSize(800, 300);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

    private Component northPane(List<Currency> currencies) {
        JPanel northPane = new JPanel();
        fromCurrenciesDialog = new SwingCurrenciesDialog();
        fromCurrenciesDialog.display(currencies);
        toCurrenciesDialog = new SwingCurrenciesDialog();
        toCurrenciesDialog.display(currencies);
        northPane.add((Component) fromCurrenciesDialog);
        northPane.add((Component) toCurrenciesDialog);
        return northPane;
    }

    private Component convertButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(e -> {
            try {
                this.commands.get("convert").execute();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } // TODO -> Remove exception. Must be managed in control class.
        });
        return button;
    }

    public CurrenciesDialog getToCurrenciesDialog() {
        return toCurrenciesDialog;
    }

    public DateDialog getDateDialog() {
        return dateDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }
}
