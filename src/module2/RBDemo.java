package module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RBDemo implements ActionListener {

    JLabel labelOptions;
    JLabel labelWhat;
    JCheckBox checkBoxOptions;
    JRadioButton radioButtonSpeed;
    JRadioButton radioButtonSize;
    JRadioButton radioButtonDebug;

    public RBDemo() {
        JFrame frame = new JFrame("Demonstrate Radio Button");
        frame.setLayout(new GridLayout(6, 1));
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelOptions = new JLabel("Chose option: ");
        labelWhat = new JLabel("Option selected: Speed");

        checkBoxOptions = new JCheckBox("Enable Option");

        radioButtonSpeed = new JRadioButton("Maximize Speed", true);
        radioButtonSize = new JRadioButton("Minimize Speed");
        radioButtonDebug = new JRadioButton("Debug");

        radioButtonSpeed.setEnabled(false);
        radioButtonSize.setEnabled(false);
        radioButtonDebug.setEnabled(false);

        checkBoxOptions.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBoxOptions.isSelected()) {
                    radioButtonSpeed.setEnabled(true);
                    radioButtonSize.setEnabled(true);
                    radioButtonDebug.setEnabled(true);
                } else {
                    radioButtonSpeed.setEnabled(false);
                    radioButtonSize.setEnabled(false);
                    radioButtonDebug.setEnabled(false);
                }
            }
        });

        radioButtonSpeed.addActionListener(this);
        radioButtonSize.addActionListener(this);
        radioButtonDebug.addActionListener(this);

        frame.add(checkBoxOptions);
        frame.add(labelOptions);

        frame.add(radioButtonSpeed);
        frame.add(radioButtonSize);
        frame.add(radioButtonDebug);
        frame.add(labelWhat);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opts = "";
    }

    public void itemStateChanged(ItemEvent e) {
        String opts = "";
        JCheckBox checkBox = (JCheckBox) e.getItem();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            labelWhat.setText("Selection change: " + checkBox.getText() + " selected.");
        } else {
            labelWhat.setText("Selection change: " + checkBox.getText() + " cleared");
        }
        if (radioButtonSpeed.isSelected()) {
            opts = "Speed";
        } else if(radioButtonSize.isSelected()) {
            opts = "Size";
        } else  {
            opts = "Debug";
        }

        labelWhat.setText("Option selected: " + opts);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RBDemo();
            }
        });
    }
}
