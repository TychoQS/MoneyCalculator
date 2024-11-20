package software.ulpgc.MoneyCalculator.api.io.pojos;

import java.util.List;
import java.util.Map;

public record ExchangeRatesSymbolsGetResponse(Success success, List<Symbol> symbols) {
    public record Symbol(Map<String, String> response) {
    }
    public record Success (boolean value) {
    }
}
