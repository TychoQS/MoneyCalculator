package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.ExchangeRatesSymbolsGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.time.LocalDate;

public class CurrencyLayerExchangeRateAdapter implements ExchangeRateAdapter {


    public CurrencyLayerExchangeRateAdapter() {
    }

    @Override
    public ExchangeRate adapt(Object object, Currency fromCurrency, Currency toCurrency) {
        CurrencyLayerExchangeRateGetResponse response = (CurrencyLayerExchangeRateGetResponse) object;
        return adapt(response.timestampt(), response.exchangeRate(), fromCurrency, toCurrency);
    }

    private ExchangeRate adapt(long timestampt, CurrencyLayerExchangeRateGetResponse.ExchangeRate exchangeRate, Currency from, Currency to) {
        return new ExchangeRate(getLocalDate(timestampt), exchangeRate.rate(), from, to);
    }

    private LocalDate getLocalDate(long timestampt) {
        return LocalDate.EPOCH.plusDays(timestampt/86400);
    }
}
