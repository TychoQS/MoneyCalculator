package software.ulpgc.MoneyCalculator.apps.swing.mainframe.displays;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public static final int FONT_SIZE = 15;

    public SwingMoneyDisplay() {
        super();
        this.setFont(this.setFont());
    }

    private static double getRoundedAmount(Money money) {
        BigDecimal amount = BigDecimal.valueOf(money.getAmount());
        BigDecimal roundedAmount = amount.setScale(2, RoundingMode.DOWN);
        return roundedAmount.doubleValue();
    }

    private Font setFont() {
        return new Font("Arial", Font.PLAIN, FONT_SIZE);
    }

    @Override
    public void display(Money money) {
        this.setText(getRoundedAmount(money) + " " + money.getCurrency().getCode());
        this.putClientProperty("money", money);
    }

    @Override
    public Money getMoney() {
        return (Money) this.getClientProperty("money");
    }

    @Override
    public boolean isEmpty() {
        return this.getText().isEmpty();
    }
}
