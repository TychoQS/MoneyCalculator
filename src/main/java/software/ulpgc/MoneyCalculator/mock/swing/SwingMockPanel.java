package software.ulpgc.MoneyCalculator.mock.swing;

import javax.swing.*;

public class SwingMockPanel {

    private final JPanel jPanel;

    public SwingMockPanel() {
        jPanel = new JPanel();
        jPanel.add(new JLabel("Mock label pane"));
    }

    public JPanel create() {
        return jPanel;
    }
}
