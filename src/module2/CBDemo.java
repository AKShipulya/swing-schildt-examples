package module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CBDemo implements ItemListener {

    JLabel labelOptions;
    JLabel labelWhat;
    JLabel labelChange;
    JCheckBox checkBoxOption;
    JCheckBox checkBoxSpeed;
    JCheckBox checkBoxSize;
    JCheckBox checkBoxDebug;

    public CBDemo() {
        JFrame frame = new JFrame("Demonstrate Check Box");
        frame.setLayout(new GridLayout(7, 1));
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelOptions = new JLabel("Options:");
        labelChange = new JLabel("");
        labelWhat = new JLabel("Options selected:");

        checkBoxOption = new JCheckBox("Enable Options");
        checkBoxSpeed = new JCheckBox("Maximize Speed");
        checkBoxSize = new JCheckBox("Maximize Size");
        checkBoxDebug = new JCheckBox("Debug");

        checkBoxSpeed.setEnabled(false);
        checkBoxSize.setEnabled(false);
        checkBoxDebug.setEnabled(false);

        checkBoxOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBoxOption.isSelected()) {
                    checkBoxSpeed.setEnabled(true);
                    checkBoxSize.setEnabled(true);
                    checkBoxDebug.setEnabled(true);
                } else {
                    checkBoxSpeed.setEnabled(false);
                    checkBoxSize.setEnabled(false);
                    checkBoxDebug.setEnabled(false);
                }
            }
        });

        checkBoxSpeed.addItemListener(this);
        checkBoxSize.addItemListener(this);
        checkBoxDebug.addItemListener(this);

        frame.add(checkBoxOption);
        frame.add(labelOptions);

        frame.add(checkBoxSpeed);
        frame.add(checkBoxSize);
        frame.add(checkBoxDebug);
        frame.add(labelChange);
        frame.add(labelWhat);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String options = "";

        JCheckBox checkBox = (JCheckBox) e.getItem();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            labelChange.setText("Selection change: " + checkBox.getText() + " selected.");
        } else {
            labelChange.setText("Selection change: " + checkBox.getText() + " cleared.");
        }

        if (checkBoxSpeed.isSelected()) {
            options += "Speed ";
        }

        if (checkBoxSize.isSelected()) {
            options += "Size ";
        }

        if (checkBoxDebug.isSelected()) {
            options += "Debug ";
        }

        labelWhat.setText("Option selected: " + options);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CBDemo();
            }
        });
    }
}
