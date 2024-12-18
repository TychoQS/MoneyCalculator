package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;

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
    public void execute() throws IOException {
        this.dialog.setMoney(displayMoney);
        this.display.display(dialogMoney);
    }
}
