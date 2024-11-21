package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrencyDisplay;
import software.ulpgc.MoneyCalculator.mock.swing.SwingMockPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMainFrame extends JFrame {

    private final List<Currency> currencies;

    public SwingMainFrame(List<Currency> currencies) throws HeadlessException {
        super();
        this.currencies = currencies;
        initFrame();
        this.add(BorderLayout.NORTH, titlePane());
        this.add(BorderLayout.CENTER, centerPane());
        // TODO -> Añadir el resto de componentes para la visualización básica
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
        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
        centerPane.add(exchangePane());
        return centerPane;
    }

    private Component exchangePane() {
        return new SwingExchangePane(currencies).create();
    }

    private Component titlePane() {
        return new SwingTitlePane().create();
    }
}
