package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMainFrame extends JFrame {

    private final List<Currency> currencies;
    private SwingCurrenciesDialogsPane swingCurrenciesDialogsPane;
    private SwingConversionPane swingConversionPane;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        super();
        this.currencies = currencies;
        initFrame();
        this.add(BorderLayout.NORTH, titlePane());
        this.add(BorderLayout.CENTER, centerPane());

        // TODO -> Añadir el resto de componentes para la visualización básica
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
        this.setTitle("Money Calculator");
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
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
