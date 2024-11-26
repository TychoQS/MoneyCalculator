package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.control.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class SwingMainFrame extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Money Calculator";
    private final List<Currency> currencies;
    private final HashMap<String, Command> commands;
    private SwingCurrenciesDialogsPane swingCurrenciesDialogsPane;
    private SwingConversionPane swingConversionPane;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        super();
        this.currencies = currencies;
        this.commands = new HashMap<String, Command>();
        initFrame();
        this.add(titlePane());
        this.add(centerPane());
    }

    public Command put(String key, Command value) {
        return commands.put(key, value);
    }

    public CurrenciesDialog getFromCurrency() {
        return swingCurrenciesDialogsPane.getFromCurrency();
    }

    public CurrenciesDialog getToCurrency() {
        return swingCurrenciesDialogsPane.getToCurrency();
    }

    public MoneyDialog getMoneyDialog() {
        return swingConversionPane.getMoneyDialog();
    }

    public MoneyDisplay getMoneyDisplay() {
        return swingConversionPane.getMoneyDisplay();
    }

    private void initFrame() {
        this.setTitle(TITLE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private Component centerPane() {
        JPanel centerPane = new JPanel();
        centerPane.setLayout(new BorderLayout());
        centerPane.add(BorderLayout.NORTH, currenciesDialogPane());
        centerPane.add(BorderLayout.CENTER, conversionPane());
        return centerPane;
    }
    private Component conversionPane() {
        swingConversionPane = new SwingConversionPane(commands, getFromCurrency());
        return swingConversionPane.getConversionPane();
    }

    private Component currenciesDialogPane() {
        swingCurrenciesDialogsPane = new SwingCurrenciesDialogsPane(currencies, commands);
        return swingCurrenciesDialogsPane.getCurrenciesDialogsPane();
    }

    private Component titlePane() {
        return new SwingTitlePane().getTitlePane();
    }
}
