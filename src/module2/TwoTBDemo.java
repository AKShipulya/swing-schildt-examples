package module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TwoTBDemo implements ItemListener {

    JLabel labelAlpha;
    JLabel labelBeta;
    JToggleButton btnAlpha;
    JToggleButton btnBeta;

    public TwoTBDemo() {
        JFrame frame = new JFrame("Two toggle buttons");
        frame.setLayout(new FlowLayout());
        frame.setSize(120, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelAlpha = new JLabel("Alpha is off...");
        labelBeta = new JLabel("Beta is off...");

        btnAlpha = new JToggleButton("Alpha");
        btnBeta = new JToggleButton("Beta");

        btnAlpha.addItemListener(this);
        btnBeta.addItemListener(this);

        frame.add(btnAlpha);
        frame.add(labelAlpha);
        frame.add(btnBeta);
        frame.add(labelBeta);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JToggleButton toggleButton = (JToggleButton) e.getItem();
        if (toggleButton == btnAlpha) {
            if (toggleButton.isSelected()) {
                labelAlpha.setText("Alpha is on...");
            } else {
                labelAlpha.setText("Alpha is off...");
            }
        } else if (toggleButton == btnBeta) {
            if (toggleButton.isSelected()) {
                labelBeta.setText("Beta is on...");
            } else {
                labelBeta.setText("Beta is off...");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TwoTBDemo();
            }
        });
    }
}
