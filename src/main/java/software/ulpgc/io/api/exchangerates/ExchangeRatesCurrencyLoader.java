package software.ulpgc.io.api.exchangerates;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.model.Currency;
import software.ulpgc.model.CurrencyLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesCurrencyLoader implements CurrencyLoader {

    @Override
    public List<Currency> load() throws IOException {
        return fromJsonCurrencyList(loadJson());

    }

    private List<Currency> fromJsonCurrencyList(String replyString) {
        Map<String, JsonElement> currencyCodeToName = new Gson().fromJson(replyString, JsonObject.class).get("symbols").getAsJsonObject().asMap();
        List<Currency> currencies = new ArrayList<>();
        for (String code : currencyCodeToName.keySet()) {
            currencies.add(new Currency(code, currencyCodeToName.get(code).toString(), "100"));
        }
        return currencies;
    }

    private String loadJson() throws IOException {
        URL url = new URL("http://api.exchangeratesapi.io/v1/symbols?access_key=" + ExchangeRatesApi.apiKey);
        try (InputStream inputStream = url.openStream()) {
                return new String(inputStream.readAllBytes());
        }
    }
}
