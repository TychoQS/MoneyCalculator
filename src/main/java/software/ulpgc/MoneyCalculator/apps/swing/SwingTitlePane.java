package software.ulpgc.MoneyCalculator.apps.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SwingTitlePane {
    private final JPanel pane;
    private JLabel titleLabel;

    public SwingTitlePane() {
        pane = new JPanel();
        pane.add(getTitle());
    }

    private Component getTitle() {
        this.titleLabel = new JLabel("Money Calculator");
        titleLabel.setFont(getFont());
        return titleLabel;
    }

    private Font getFont() {
        return new Font("Montserrat", Font.BOLD|Font.ITALIC, adaptFontSize());
    }

    private int adaptFontSize() {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 100;
    }

    public JPanel create() {
        return pane;
    }
}
