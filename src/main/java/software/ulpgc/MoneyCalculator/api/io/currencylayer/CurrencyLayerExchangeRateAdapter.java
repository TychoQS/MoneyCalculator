package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class CurrencyLayerExchangeRateAdapter implements ExchangeRateAdapter {


    public CurrencyLayerExchangeRateAdapter() {
    }

    @Override
    public ExchangeRate adapt(Object object, Currency fromCurrency, Currency toCurrency) throws IOException {
        CurrencyLayerExchangeRateGetResponse response = (CurrencyLayerExchangeRateGetResponse) object;
        return adapt(response.timestamp(), response.quotes(), fromCurrency, toCurrency);
    }

    private ExchangeRate adapt(long timestampt, Map<String, Double> quotes, Currency fromCurrency, Currency toCurrency) throws IOException {
        return new ExchangeRate(getLocalDate(timestampt), getRate(quotes), fromCurrency, toCurrency);
    }

    private double getRate(Map<String, Double> quotes) throws IOException {
        try {
            return quotes.isEmpty() ? 1 : quotes.entrySet().iterator().next().getValue();
        } catch (NullPointerException ex) {
            throw new IOException("Too many request. Don't spam convert button");
        }
    }

    private LocalDate getLocalDate(long timestampt) {
        return LocalDate.EPOCH.plusDays(timestampt/86400);
    }
}
