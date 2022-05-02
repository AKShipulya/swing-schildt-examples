package module2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ChangeDemo {

    JButton button;
    JLabel label;

    public ChangeDemo() {
        JFrame frame = new JFrame("Button Change Events");
        frame.setLayout(new FlowLayout());
        frame.setSize(250, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        button = new JButton("Press for Change Event Test");

        button.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = button.getModel();
                String what = "";
                if (model.isEnabled()) {
                    what += "Enabled<br>";
                }
                if (model.isRollover()) {
                    what += "Rollover<br>";
                }
                if (model.isArmed()) {
                    what += "Armed<br>";
                }
                if (model.isPressed()) {
                    what += "Pressed<br>";
                }
                label.setText("<html>Current state:<br>" + what);
            }
        });

        frame.add(button);
        frame.add(label);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangeDemo();
            }
        });
    }

}
