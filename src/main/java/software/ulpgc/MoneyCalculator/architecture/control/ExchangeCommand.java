package software.ulpgc.MoneyCalculator.architecture.control;

import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;

public class ExchangeCommand implements Command {

    private final CurrenciesDialog fromCurrency;
    private final CurrenciesDialog toCurrency;
    private final MoneyDialog dialog;
    private final MoneyDisplay display;

    public ExchangeCommand(CurrenciesDialog fromCurrency, CurrenciesDialog toCurrency, MoneyDialog dialog, MoneyDisplay display) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.dialog = dialog;
        this.display = display;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Mock implementation exchange command");
    }
}
