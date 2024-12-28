package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import software.ulpgc.MoneyCalculator.apps.swing.date.conversion.frame.SwingDateMoneyConversionFrame;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class SwingMainFrame extends JFrame {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private static final String TITLE = "Money Calculator";
    private static final String JMENU_ITEM_TEXT = "Date Money Conversion";
    private static final String JMENU_TEXT = "Date Operations";
    private final List<Currency> currencies;
    private final HashMap<String, Command> commands;
    private final SwingDateMoneyConversionFrame swingDateMoneyConversionFrame;
    private SwingCurrenciesDialogsPane swingCurrenciesDialogsPane;
    private SwingConversionPane swingConversionPane;
    private JMenuBar jMenuBar;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        super();
        this.currencies = currencies;
        this.commands = new HashMap<>();
        this.swingDateMoneyConversionFrame = new SwingDateMoneyConversionFrame(currencies);
        initFrame();
        this.add(titlePane());
        this.add(centerPane());
    }

    public SwingDateMoneyConversionFrame getDateMoneyConversionFrame() {
        return swingDateMoneyConversionFrame;
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
            swingDateMoneyConversionFrame.setVisible(true);
            swingDateMoneyConversionFrame.setLocationRelativeTo(SwingMainFrame.this);
        });
        return jMenuItem;
    }

    public SwingMainFrame putOnMainFrameCommands(String key, Command value) {
        commands.put(key, value);
        return this;
    }

    public SwingMainFrame putOnDateConversionFrameCommands(String key, Command value) {
        swingDateMoneyConversionFrame.put(key, value);
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
