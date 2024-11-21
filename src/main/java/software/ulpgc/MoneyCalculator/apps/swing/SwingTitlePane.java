package software.ulpgc.MoneyCalculator.apps.swing;

import javax.swing.*;
import java.awt.*;

public class SwingTitlePane {
    private final JPanel titlePane;
    private JLabel titleLabel;

    public SwingTitlePane() {
        titlePane = new JPanel();
        titlePane.add(getTitle());
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

    public JPanel getTitlePane() {
        return titlePane;
    }
}
