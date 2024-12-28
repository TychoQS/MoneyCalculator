package software.ulpgc.MoneyCalculator.architecture.control.commands;

import java.io.IOException;

public interface Command { //TODO -> Look for IOException source
    void execute() throws IOException;
}
