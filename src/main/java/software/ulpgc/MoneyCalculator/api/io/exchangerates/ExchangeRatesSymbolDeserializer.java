package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.ExchangeRatesSymbolsGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.SymbolDeserializer;

public class ExchangeRatesSymbolDeserializer implements SymbolDeserializer {
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, ExchangeRatesSymbolsGetResponse.class);
    }
}
