package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import software.ulpgc.MoneyCalculator.apps.swing.moneyconversionframe.SwingDateMoneyConversionFrame;
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

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Money Calculator";
    public static final String JMENU_ITEM_TEXT = "Date Money Conversion";
    public static final String JMENU_TEXT = "Date Operations";
    private final List<Currency> currencies;
    private final HashMap<String, Command> commands;
    private SwingCurrenciesDialogsPane swingCurrenciesDialogsPane;
    private SwingConversionPane swingConversionPane;
    private JMenuBar jMenuBar;
    private SwingDateMoneyConversionFrame swingDateMoneyConversionFrame;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        super();
        this.currencies = currencies;
        this.commands = new HashMap<>();
        initFrame();
        this.add(titlePane());
        this.add(centerPane());
    }

    private void initFrame() {
        this.setTitle(TITLE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(buildJMenuBar());
    }

    private Component titlePane() {
        return new SwingTitlePane().getTitlePane();
    }

    private Component centerPane() {
        JPanel centerPane = new JPanel();
        centerPane.setLayout(new BorderLayout());
        centerPane.add(BorderLayout.NORTH, currenciesDialogPane());
        centerPane.add(BorderLayout.CENTER, conversionPane());
        return centerPane;
    }

    private JMenuBar buildJMenuBar() {
        this.jMenuBar = new JMenuBar();
        this.jMenuBar.add(getJMenu());
        return jMenuBar;
    }

    private Component currenciesDialogPane() {
        swingCurrenciesDialogsPane = new SwingCurrenciesDialogsPane(currencies, commands);
        return swingCurrenciesDialogsPane.getCurrenciesDialogsPane();
    }

    private Component conversionPane() {
        swingConversionPane = new SwingConversionPane(commands, getFromCurrency());
        return swingConversionPane.getConversionPane();
    }

    private Component getJMenu() {
        JMenu jMenu = new JMenu(JMENU_TEXT);
        jMenu.add(buildJMenuItem());
        return jMenu;
    }

    public CurrenciesDialog getFromCurrency() {
        return swingCurrenciesDialogsPane.getFromCurrency();
    }

    private JMenuItem buildJMenuItem() {
        JMenuItem jMenuItem = new JMenuItem(JMENU_ITEM_TEXT);
        jMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jMenuItem.addActionListener(e -> {
            swingDateMoneyConversionFrame = new SwingDateMoneyConversionFrame(currencies, commands);
        });
        return jMenuItem;
    }

    public SwingMainFrame put(String key, Command value) {
        commands.put(key, value);
        return this;
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

    public CurrenciesDialog getDateConversionToCurrenciesDialog() {
        return swingDateMoneyConversionFrame.getToCurrenciesDialog();
    }
}
