package module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToggleDemo {

    JLabel label;
    JToggleButton button;

    public ToggleDemo() {
        JFrame frame = new JFrame("Demonstrate a toggle button");
        frame.setLayout(new FlowLayout());
        frame.setSize(290, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Button is OFF");
        button = new JToggleButton("ON/OFF");

        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (button.isSelected()) {
                    label.setText("Button is ON");
                } else {
                    label.setText("Button is OFF");
                }
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToggleDemo();
            }
        });
    }
}
