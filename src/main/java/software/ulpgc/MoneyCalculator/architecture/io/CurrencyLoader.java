package software.ulpgc.MoneyCalculator.architecture.io;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.IOException;
import java.util.List;

public interface CurrencyLoader {
    List<Currency> load() throws IOException;
}
