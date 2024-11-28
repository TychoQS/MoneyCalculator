package software.ulpgc.MoneyCalculator.apps.swing;

import javax.swing.*;
import java.awt.*;

public class SwingTitlePane {
    private final JPanel titlePane;
    private JLabel titleLabel;

    public SwingTitlePane()  {
        titlePane = new JPanel();
        titlePane.add(getTitle());
        // TODO -> Fix Title Font
    }

    private Component getTitle() {
        this.titleLabel = new JLabel("Money Calculator");
        titleLabel.setFont(getFont());
        return titleLabel;
    }

    private Font getFont() {
        return new Font("Power Red and Green", Font.BOLD, adaptFontSize());
    }

    private int adaptFontSize() {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 100;
    }

    public JPanel getTitlePane() {
        return titlePane;
    }
}
