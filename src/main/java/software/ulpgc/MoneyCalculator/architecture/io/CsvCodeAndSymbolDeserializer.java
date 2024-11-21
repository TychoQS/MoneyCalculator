package software.ulpgc.MoneyCalculator.architecture.io;

import java.util.List;

public class CsvCodeAndSymbolDeserializer implements codeAndSymbolDeserializer {
    @Override
    public List<String> deserialize(String line) {
        return deserialize(line.split(","));
    }

    private List<String> deserialize(String[] fields) {
        return List.of(fields[0], fields[1]);
    }
}