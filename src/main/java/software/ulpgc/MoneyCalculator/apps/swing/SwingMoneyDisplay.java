package software.ulpgc.MoneyCalculator.apps.swing;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    public SwingMoneyDisplay() {
        super();
    }

    @Override
    public void display(Money money) {
        this.setText(money.getAmount() + " " + money.getCurrency().getCode());
    }
}
