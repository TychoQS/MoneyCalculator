package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;

public class ConvertCommand implements Command{

    private final CurrenciesDialog toCurrencyDialog;
    private final MoneyDialog dialog;
    private final MoneyDisplay display;
    private final ExchangeRateLoader loader;

    public ConvertCommand(CurrenciesDialog toCurrenciesDialog, MoneyDialog dialog, MoneyDisplay display, ExchangeRateLoader loader) {
        this.toCurrencyDialog = toCurrenciesDialog;
        this.dialog = dialog;
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() throws IOException {
        if (ConversorValidator.validate(dialog)) new DisplayConvertedMoneyCommand(display, getConvertedMoney()).execute();;
    }

    private Money getConvertedMoney() throws IOException {
        return MoneyConverter.convert(dialog.getMoney(), loader.load(this.dialog.getMoney().getCurrency(), toCurrencyDialog.getSelectedCurrency()));
    }
}
