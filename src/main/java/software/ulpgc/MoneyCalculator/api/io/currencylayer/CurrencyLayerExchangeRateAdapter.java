package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.time.LocalDate;
import java.util.Map;

public class CurrencyLayerExchangeRateAdapter implements ExchangeRateAdapter {


    public CurrencyLayerExchangeRateAdapter() {
    }

    @Override
    public ExchangeRate adapt(Object object, Currency fromCurrency, Currency toCurrency) {
        CurrencyLayerExchangeRateGetResponse response = (CurrencyLayerExchangeRateGetResponse) object;
        return adapt(response.timestamp(), response.quotes(), fromCurrency, toCurrency);
    }

    private ExchangeRate adapt(long timestampt, Map<String, Double> quotes, Currency from, Currency to) {
        return new ExchangeRate(getLocalDate(timestampt), getRate(quotes), from, to);
    }

    private double getRate(Map<String, Double> quotes) {
        return quotes.isEmpty() ? 1 : quotes.entrySet().iterator().next().getValue();
    }

    private LocalDate getLocalDate(long timestampt) {
        return LocalDate.EPOCH.plusDays(timestampt/86400);
    }
}
