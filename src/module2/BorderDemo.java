package module2;

import javax.swing.*;
import java.awt.*;

public class BorderDemo {

    public BorderDemo() {
        JFrame frame = new JFrame("Use line and Etched border");
        frame.setLayout(new FlowLayout());
        frame.setSize(280, 90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("This uses a line border. ");
        label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel label2 = new JLabel("This uses a etched Border. ");
        label2.setBorder(BorderFactory.createEtchedBorder());

        frame.add(label1);
        frame.add(label2);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderDemo();
            }
        });
    }
}
