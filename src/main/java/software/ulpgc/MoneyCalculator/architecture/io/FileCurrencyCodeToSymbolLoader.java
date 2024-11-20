package software.ulpgc.MoneyCalculator.architecture.io;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class FileCurrencyCodeToSymbolLoader implements CurrencyCodeToSymbolLoader {
    private final CurrencyCodeToSymbolDeserializer deserializer;
    private final File file;

    public FileCurrencyCodeToSymbolLoader(File file, CurrencyCodeToSymbolDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public Map<String, String> load() throws IOException {
        Map<String, String> currenciesCodesToSymbols = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())))) {
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                CurrencyCodeToSymbol currencyCodeToSymbol = deserializer.deserialize(line);
                currenciesCodesToSymbols.put(currencyCodeToSymbol.code(), currencyCodeToSymbol.symbol());
            }
        }
        return currenciesCodesToSymbols;
    }
}
