package software.ulpgc.MoneyCalculator.api.io.currencylayer.simple;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;

public class CurrencyLayerExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public Object deserialize(String read) {
        System.out.println(new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class));
        return new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class);
    }
}
