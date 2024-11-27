package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;

public class ExchangeCommand implements Command {

    private final CurrenciesDialog fromCurrencyDialog;
    private final CurrenciesDialog toCurrencyDialog;
    private final MoneyDialog dialog;
    private final MoneyDisplay display;

    public ExchangeCommand(CurrenciesDialog fromCurrencyDialog, CurrenciesDialog toCurrencyDialog, MoneyDialog dialog, MoneyDisplay display) {
        this.fromCurrencyDialog = fromCurrencyDialog;
        this.toCurrencyDialog = toCurrencyDialog;
        this.dialog = dialog;
        this.display = display;
    }

    @Override
    public void execute() throws IOException {
        if (SwapMoneyDisplayAndDialogValidator.validate(dialog, display)) new SwapMoneyDisplayAndDialogCommand(display, dialog).execute();
        new SwapCurrenciesDialogCommand(fromCurrencyDialog, toCurrencyDialog).execute();
        // TODO -> Look how to implemet the exchange of Money
    }
}
