package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.control.MoneyConverter;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.DateExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;

public class ConvertFromDateCommand implements Command {

    private final CurrenciesDialog toCurrencyDialog;
    private final DateDialog dateDialog;
    private final MoneyDisplay display;
    private final MoneyDialog moneyDialog;
    private final DateExchangeRateLoader loader;

    public ConvertFromDateCommand(CurrenciesDialog toCurrencyDialog, DateDialog dateDialog, MoneyDisplay display, MoneyDialog moneyDialog, DateExchangeRateLoader loader) {
        this.toCurrencyDialog = toCurrencyDialog;
        this.dateDialog = dateDialog;
        this.display = display;
        this.moneyDialog = moneyDialog;
        this.loader = loader;
    }

    @Override
    public void execute() throws IOException {
        if (!moneyDialog.isEmpty()) new DisplayConvertedMoneyCommand(this.display, getConvertedMoney()).execute();
    }

    private Money getConvertedMoney() throws IOException {
        return MoneyConverter.convert(moneyDialog.getMoney(), loader.load(this.moneyDialog.getMoney().getCurrency(), toCurrencyDialog.getSelectedCurrency(), dateDialog.getDate()));
    }
}
