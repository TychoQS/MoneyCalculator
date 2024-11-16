package software.ulpgc.MoneyCalculator.architecture.model;

import java.io.IOException;
import java.util.List;

public interface CurrencyLoader {
    List<Currency> load() throws IOException;
}
