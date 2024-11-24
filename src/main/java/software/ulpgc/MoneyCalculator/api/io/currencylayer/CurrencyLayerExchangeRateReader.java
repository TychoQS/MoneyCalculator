package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class CurrencyLayerExchangeRateReader implements ExchangeRateReader {

    public CurrencyLayerExchangeRateReader() {
    }

    @Override
    public String read(String fromCurrencyCode, String toCurrencyCode) throws IOException {
        return read(CurrencyLayerApi.getExchangeRateEndpoint(fromCurrencyCode, toCurrencyCode));
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
