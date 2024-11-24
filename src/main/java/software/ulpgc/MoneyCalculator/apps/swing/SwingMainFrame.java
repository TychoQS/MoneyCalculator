package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.mock.swing.SwingMockPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMainFrame extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Money Calculator";
    private final List<Currency> currencies;
    private SwingCurrenciesDialogsPane swingCurrenciesDialogsPane;
    private SwingConversionPane swingConversionPane;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        super();
        this.currencies = currencies;
        initFrame();
        this.add(titlePane());
        this.add(centerPane());
        //this.add(Box.createVerticalGlue());
        // TODO -> Añadir Panel para mostrar el MoneyDisplay
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

    private void initFrame() {
        this.setTitle(TITLE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private Component centerPane() {
        JPanel centerPane = new JPanel();
        centerPane.setLayout(new BorderLayout());
        centerPane.add(BorderLayout.NORTH, currenciesDialogPane());
        centerPane.add(BorderLayout.CENTER, conversionPane());
        centerPane.add(BorderLayout.SOUTH, new SwingMockPanel().create());
        return centerPane;
    }
    private Component conversionPane() {
        swingConversionPane = new SwingConversionPane(getFromCurrency());
        return swingConversionPane.getConversionPane();
    }

    private Component currenciesDialogPane() {
        swingCurrenciesDialogsPane = new SwingCurrenciesDialogsPane(currencies);
        return swingCurrenciesDialogsPane.getCurrenciesDialogsPane();
    }

    private Component titlePane() {
        return new SwingTitlePane().getTitlePane();
    }
}
