package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.ExchangeRateDeserializer;

public class CurrencyLayerExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class);
    }
}
