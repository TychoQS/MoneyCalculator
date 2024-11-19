package software.ulpgc.MoneyCalculator.api.io.pojos;

import java.util.List;

public record ExchangeRatesSymbolsGetResponse(List<Symbol> response) {
    public record Symbol(String code, String name) {
    }
}
