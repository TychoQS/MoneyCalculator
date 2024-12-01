package software.ulpgc.MoneyCalculator.api.io.currencylayer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerGetResponseError;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;

public class CurrencyLayerExchangeRateDeserializer implements ExchangeRateDeserializer {
    @Override
    public Object deserialize(String read) {
        System.out.println(new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class));
        return deserialize(read, getAsJsonObject(read));
    }

    private Object deserialize(String read, JsonObject json) {
        return requestSucceded(json) ? deserializeSuccessfulResponse(read) : deserializeUnsuccessfulResponse(read);
    }

    private JsonObject getAsJsonObject(String read) {
        return JsonParser.parseString(read).getAsJsonObject();
    }

    private boolean requestSucceded(JsonObject json) {
        return json.get("success").getAsBoolean();
    }

    private CurrencyLayerExchangeRateGetResponse deserializeSuccessfulResponse(String read) {
        return new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class);
    }

    private CurrencyLayerGetResponseError deserializeUnsuccessfulResponse(String read) {
        return new Gson().fromJson(read, CurrencyLayerGetResponseError.class);
    }
}
