package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;


public class SwapMoneyDisplayAndDialogCommand implements Command {
    private final MoneyDisplay display;
    private final MoneyDialog dialog;
    private final Money displayMoney;
    private final Money dialogMoney;

    public SwapMoneyDisplayAndDialogCommand(MoneyDisplay display, MoneyDialog dialog) {
        this.display = display;
        this.dialog = dialog;
        this.displayMoney = this.display.getMoney();
        this.dialogMoney = this.dialog.getMoney();
    }

    @Override
    public void execute() {
        this.dialog.setMoney(Money.getFrom(displayMoney.getAmount(), displayMoney.getCurrency()));
        this.display.display(Money.getFrom(dialogMoney.getAmount(), dialogMoney.getCurrency()));
    }
}
