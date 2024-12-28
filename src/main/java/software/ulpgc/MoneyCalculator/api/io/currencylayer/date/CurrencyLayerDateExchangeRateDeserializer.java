package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerDateConversionGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;

public class CurrencyLayerDateExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, CurrencyLayerDateConversionGetResponse.class);
    }
}
