package software.ulpgc.MoneyCalculator.api.io.pojos;

public record CurrencyLayerExchangeRateGetResponse(boolean success, String terms, String privacy, long timestampt, String source, ExchangeRate exchangeRate) {
    public record ExchangeRate(double rate) {}
}
