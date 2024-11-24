package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public static final int FONT_SIZE = 15;

    public SwingMoneyDisplay() {
        super();
        this.setFont(this.setFont());
    }

    private Font setFont() {
        return new Font("Arial", Font.PLAIN, FONT_SIZE);
    }

    @Override
    public void display(Money money) {
        this.setText(money.getAmount() + " " + money.getCurrency().getCode());
    }
}
