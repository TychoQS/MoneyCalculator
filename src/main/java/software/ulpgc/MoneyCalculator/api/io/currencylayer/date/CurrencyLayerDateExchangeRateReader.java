package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.CurrencyLayerApi;
import software.ulpgc.MoneyCalculator.architecture.io.readers.DateExchangeRateReader;
import software.ulpgc.MoneyCalculator.architecture.io.readers.ExchangeRateReader;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.jsoup.Connection.Method.GET;

public class CurrencyLayerDateExchangeRateReader implements DateExchangeRateReader {

    public static void main(String[] args) throws IOException {
        CurrencyLayerDateExchangeRateReader reader = new CurrencyLayerDateExchangeRateReader();
        System.out.println(reader.read("EUR", "USD", ZonedDateTime.now()));
    }

    @Override
    public String read(String fromCurrencyCode, String toCurrencyCode, ZonedDateTime date) throws IOException {
        System.out.println("ENDPOINT URL: " + CurrencyLayerApi.getDateExchangeRateEndpoint(fromCurrencyCode, toCurrencyCode, formatted(date)));
        return read(CurrencyLayerApi.getDateExchangeRateEndpoint(fromCurrencyCode, toCurrencyCode, formatted(date)));
    }

    private String read(String dateExchangeRateEndpoint) throws IOException {
        Connection.Response response = Jsoup.connect(dateExchangeRateEndpoint)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if (response.statusCode() != 200) throw new RuntimeException();
        return response.body();
    }

    private String formatted(ZonedDateTime date) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
    }
}
