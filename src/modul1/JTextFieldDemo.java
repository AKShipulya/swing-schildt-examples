package modul1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldDemo implements ActionListener {

    JTextField textField;
    JLabel label;

    public JTextFieldDemo() {
        JFrame frame = new JFrame("A text field example");
        frame.setLayout(new FlowLayout());
        frame.setSize(240, 90);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(10);
        textField.addActionListener(this);

        frame.add(textField);

        label = new JLabel("");
        frame.add(label);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Current contents: " + textField.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTextFieldDemo();
            }
        });
    }
}
