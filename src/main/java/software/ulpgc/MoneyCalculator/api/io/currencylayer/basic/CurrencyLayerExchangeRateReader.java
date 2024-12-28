package software.ulpgc.MoneyCalculator.api.io.currencylayer.basic;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.CurrencyLayerApi;
import software.ulpgc.MoneyCalculator.architecture.io.readers.ExchangeRateReader;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class CurrencyLayerExchangeRateReader implements ExchangeRateReader {

    @Override
    public String read(String fromCurrencyCode, String toCurrencyCode) throws IOException {
        System.out.println("ENDPOINT URL: " + CurrencyLayerApi.getExchangeRateEndpoint(fromCurrencyCode, toCurrencyCode)); // TODO -> Remove this line
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
