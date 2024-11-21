package software.ulpgc.MoneyCalculator.architecture.io;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCurrencyCodeToSymbolListLoader implements CurrencyCodesToSymbolsLoader {
    public static final int CODE = 0;
    public static final int SYMBOL = 1;
    private final codeAndSymbolDeserializer deserializer;
    private final File file;

    public FileCurrencyCodeToSymbolListLoader(File file, codeAndSymbolDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public CurrencyCodesToSymbols load() throws IOException {
        return new CurrencyCodesToSymbols(getCurrencyCodeToSymbolMap());
    }

    private Map<String, String> getCurrencyCodeToSymbolMap() throws IOException {
        Map<String, String> codesToSymbols = new HashMap<>();
        try (BufferedReader reader = getBufferedReader()) {
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                codesToSymbols.put(getKey(deserializer.deserialize(line)), getValue(deserializer.deserialize(line)));
            }
        }
        return codesToSymbols;
    }

    private String getValue(List<String> codeAndSymbol) {
        return codeAndSymbol.get(SYMBOL);
    }

    private String getKey(List<String> codeAndSymbol) {
        return codeAndSymbol.get(CODE);
    }

    private BufferedReader getBufferedReader() throws IOException {
        return new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
    }
}
