package software.ulpgc.MoneyCalculator.architecture.io;

import java.util.List;

public interface codeAndSymbolDeserializer {
    List<String> deserialize(String line);
}
