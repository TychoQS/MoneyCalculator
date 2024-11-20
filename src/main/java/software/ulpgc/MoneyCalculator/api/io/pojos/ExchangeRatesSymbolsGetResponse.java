package software.ulpgc.MoneyCalculator.api.io.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public record ExchangeRatesSymbolsGetResponse(boolean success, Map<String, String> symbols) {

}
