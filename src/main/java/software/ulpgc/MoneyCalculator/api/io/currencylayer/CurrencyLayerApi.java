package software.ulpgc.MoneyCalculator.api.io.currencylayer;

public class CurrencyLayerApi {
    public static String apiKey= "d103d311647949d609482f4c93f62012";
    private static String ExchangeRateEndpoint = "https://api.currencylayer.com/live?access_key=%s&source=%s&currencies=%s";

    public static String getExchangeRateEndpoint(String fromCurrency, String toCurrency) {
        return String.format(ExchangeRateEndpoint, apiKey, fromCurrency, toCurrency);
    }

    public static void main(String[] args) {
        System.out.println(CurrencyLayerApi.getExchangeRateEndpoint("USD", "EUR"));
    }
}
