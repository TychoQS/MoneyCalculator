package software.ulpgc.MoneyCalculator.apps.swing;

import javax.swing.*;
import java.awt.*;

public class SwingTitlePane {
    public static final Color LABEL_COLOR = Color.BLACK;
    public static final String LABEL_TEXT = "Money Calculator";
    private static final int LABEL_PREFERRED_WIDTH = 300;
    private static final int LABEL_PREFERRED_HEIGHT = 60;
    private static final String FONT_NAME = "Power Green Narrow";
    private final JPanel titlePane;
    private JLabel titleLabel;

    public SwingTitlePane() {
        titlePane = new JPanel();
        titlePane.add(getTitleLabel());
    }

    private Component getTitleLabel() {
        this.titleLabel = new JLabel(LABEL_TEXT);
        titleLabel.setFont(getFont());
        titleLabel.setPreferredSize(getPreferredSize());
        titleLabel.setForeground(LABEL_COLOR);
        return titleLabel;
    }

    private Font getFont() {
        return new Font(FONT_NAME, Font.PLAIN, adaptFontSize());
    }

    private Dimension getPreferredSize() {
        return new Dimension(LABEL_PREFERRED_WIDTH, LABEL_PREFERRED_HEIGHT);
    }

    private int adaptFontSize() {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 50;
    }

    public JPanel getTitlePane() {
        return titlePane;
    }
}
