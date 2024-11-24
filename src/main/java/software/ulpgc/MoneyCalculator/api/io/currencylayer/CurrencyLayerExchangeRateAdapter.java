package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.ExchangeRatesSymbolsGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.time.LocalDate;

public class CurrencyLayerExchangeRateAdapter implements ExchangeRateAdapter {

    private final Currency fromCurrency;
    private final Currency toCurrency;

    public CurrencyLayerExchangeRateAdapter(Currency fromCurrency, Currency toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    @Override
    public ExchangeRate adapt(Object object) {
        CurrencyLayerExchangeRateGetResponse response = (CurrencyLayerExchangeRateGetResponse) object;
        return adapt(response.timestampt(), response.exchangeRate());
    }

    private ExchangeRate adapt(long timestampt, CurrencyLayerExchangeRateGetResponse.ExchangeRate exchangeRate) {
        return new ExchangeRate(getLocalDate(timestampt), exchangeRate.rate(), fromCurrency, toCurrency);
    }

    private LocalDate getLocalDate(long timestampt) {
        return LocalDate.EPOCH.plusDays(timestampt/86400);
    }
}
