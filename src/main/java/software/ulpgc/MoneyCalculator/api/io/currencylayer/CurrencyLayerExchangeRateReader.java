package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class CurrencyLayerExchangeRateReader implements ExchangeRateReader {
    private final String fromCurrency;
    private final String toCurrency;

    public CurrencyLayerExchangeRateReader(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    @Override
    public String read() throws IOException {
        return read(CurrencyLayerApi.getExchangeRateEndpoint(fromCurrency, toCurrency));
    }

    private String read(String exchangeRateEndpoint) throws IOException {
        Connection.Response response = Jsoup.connect(exchangeRateEndpoint)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException();
        return response.body();
    }
}
