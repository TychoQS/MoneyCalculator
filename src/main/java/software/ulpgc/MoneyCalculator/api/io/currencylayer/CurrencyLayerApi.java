package software.ulpgc.MoneyCalculator.api.io.currencylayer;

public class CurrencyLayerApi {
    public static final String API_KEY = "f508c1f6d1c6705e296fec36513ba0ab";
    private static final String EXCHANGE_RATE_ENDPOINT = "https://api.currencylayer.com/live?access_key=%s&source=%s&currencies=%s";
    private static final String DATE_CONVERT_ENDPOINT = "https://api.currencylayer.com/convert?access_key=%s&from=%s&to=%s&amount=1&date=%s";

    public static String getExchangeRateEndpoint(String fromCurrency, String toCurrency) {
        return String.format(EXCHANGE_RATE_ENDPOINT, API_KEY, fromCurrency, toCurrency);
    }

    public static String getDateExchangeRateEndpoint(String fromCurrency, String toCurrency, String date) {
        return String.format(DATE_CONVERT_ENDPOINT, API_KEY, fromCurrency, toCurrency, date);
    }

    public static void main(String[] args) { // TODO -> Remove
        System.out.println(CurrencyLayerApi.getExchangeRateEndpoint("USD", "EUR"));
        System.out.println(CurrencyLayerApi.getDateExchangeRateEndpoint("AOA", "ARS", "2024-12-27"));
    }
}
