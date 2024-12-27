package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.io.readers.DateExchangeRateReader;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;

public class DateConvertCommand implements Command { // TODO -> Implement after fetching date exchangerate implementation

    private final CurrenciesDialog toCurrencyDialog;
    private final DateDialog dateDialog;
    private final MoneyDisplay display;
    private final MoneyDialog moneyDialog;

    public DateConvertCommand(CurrenciesDialog toCurrencyDialog, DateDialog dateDialog, MoneyDisplay display, MoneyDialog moneyDialog) {
        this.toCurrencyDialog = toCurrencyDialog;
        this.dateDialog = dateDialog;
        this.display = display;
        this.moneyDialog = moneyDialog;
    }

    @Override
    public void execute() throws IOException {
        return;
    }
}
