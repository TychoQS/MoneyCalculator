package software.ulpgc.MoneyCalculator.architecture.control;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
