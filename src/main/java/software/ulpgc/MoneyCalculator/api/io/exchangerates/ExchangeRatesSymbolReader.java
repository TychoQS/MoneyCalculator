package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class ExchangeRatesSymbolReader implements SymbolReader {
    @Override
    public String read() {
        try {
            return read(ExchangeRatesApi.SymbolEndpoint + ExchangeRatesApi.apiKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(String endpointUrl) throws IOException {
        Connection.Response response = Jsoup.connect(endpointUrl)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException();
        return response.body();
    }
}
