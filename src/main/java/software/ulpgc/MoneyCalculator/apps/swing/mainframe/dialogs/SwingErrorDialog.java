package software.ulpgc.MoneyCalculator.apps.swing.mainframe.dialogs;

import javax.swing.*;

public class SwingErrorDialog {
    public SwingErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
