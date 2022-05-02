package modul1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoTFDemo implements ActionListener {

    JTextField firstTextField;
    JTextField secondTextField;
    JLabel label;

    public TwoTFDemo() {
        JFrame frame = new JFrame("Use two text fields");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstTextField = new JTextField(10);
        secondTextField = new JTextField(10);

        firstTextField.setActionCommand("One");
        secondTextField.setActionCommand("Second");

        firstTextField.addActionListener(this);
        secondTextField.addActionListener(this);

        frame.add(firstTextField);
        frame.add(secondTextField);

        label = new JLabel("");
        frame.add(label);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("One")) {
            label.setText("ENTER pressed in first text field: " + firstTextField.getText());
        } else {
            label.setText("ENTER pressed in second text field: " + secondTextField.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TwoTFDemo();
            }
        });
    }
}
