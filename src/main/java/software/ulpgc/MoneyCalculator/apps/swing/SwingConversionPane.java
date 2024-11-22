package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

import javax.swing.*;
import java.awt.*;

public class SwingConversionPane {

    private final JPanel conversionPane;
    private final CurrenciesDialog fromCurrenciesDialog;
    private MoneyDialog moneyDialog;

    public SwingConversionPane(CurrenciesDialog fromCurrenciesDialog) {
        this.fromCurrenciesDialog = fromCurrenciesDialog;
        conversionPane = new JPanel();
        conversionPane.add(introduceAmountLabel());
        conversionPane.add(moneyDialog());
        conversionPane.add(convertButton());
    }

    private Component convertButton() {
        JButton button = new JButton("Convert");
        button.addActionListener(e -> System.out.println("Mock implementation of convert button"));
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
        return new Font("Montserrat", Font.BOLD, 15);
    }

    protected JPanel getConversionPane() {
        return conversionPane;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }
}
