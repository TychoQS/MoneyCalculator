package software.ulpgc.MoneyCalculator.api.io.currencylayer.basic;

import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerGetResponseError;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class CurrencyLayerExchangeRateAdapter implements ExchangeRateAdapter {

    public static final String APIKEY_EXPIRED_MESSAGE = "Unable to access the API as the API key usage limit has been reached.";

    @Override
    public ExchangeRate adapt(Object object, Currency fromCurrency, Currency toCurrency) throws IOException {
        try {
            CurrencyLayerExchangeRateGetResponse response = (CurrencyLayerExchangeRateGetResponse) object;
            System.out.println("Object: " + response);
            return adapt(response.timestamp(), response.quotes(), fromCurrency, toCurrency);
        } catch (ClassCastException ex) {
            CurrencyLayerGetResponseError responseError = (CurrencyLayerGetResponseError) object;
            throw new IOException(responseError.error().info());
        }
    }

    private ExchangeRate adapt(long timestamp, Map<String, Double> quotes, Currency fromCurrency, Currency toCurrency){
        return new ExchangeRate(getLocalDate(timestamp), getRate(quotes, fromCurrency, toCurrency), fromCurrency, toCurrency);
    }

    private LocalDate getLocalDate(long timestamp) {
        return LocalDate.EPOCH.plusDays(getDays(timestamp));
    }

    private double getRate(Map<String, Double> quotes, Currency fromCurrency, Currency toCurrency){
        return quotes.get(buildKey(fromCurrency, toCurrency));
    }

    private long getDays(long timestamp) {
        return timestamp / 86400;
    }

    private String buildKey(Currency fromCurrency, Currency toCurrency) {
        return fromCurrency.getCode() + toCurrency.getCode();
    }
}
