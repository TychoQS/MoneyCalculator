package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrencyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMainFrame extends JFrame {

    private final List<Currency> currencies;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(800, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(titlePane());
        this.add(exchangePane());
        // TODO -> Añadir el resto de componentes para la visualización básica
    }

    private Component exchangePane() {
        return new SwingExchangePane(currencies).create();
    }

    private Component titlePane() {
        return new SwingTitlePane().create();
    }
}
