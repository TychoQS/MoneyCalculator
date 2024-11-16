package software.ulpgc.MoneyCalculator.apps.swing;

import javax.swing.*;
import java.awt.*;

public class SwingMainFrame extends JFrame {

    public SwingMainFrame() throws HeadlessException {
        this.setTitle("Money Calculator");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(titlePane());
    }

    private Component titlePane() {
        return new SwingTitlePane().create();
    }
}
