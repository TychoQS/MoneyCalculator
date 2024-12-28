package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerDateConversionGetResponse;

public class CurrencyLayerDateConversionDeserializer implements DateConversionDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, CurrencyLayerDateConversionGetResponse.class);
    }
}
