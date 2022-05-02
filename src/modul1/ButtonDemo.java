package modul1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {

    JLabel jLabel;

    public ButtonDemo() {
        JFrame jFrame = new JFrame("A Button Example");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(220, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton firstButton = new JButton("First");
        JButton secondButton = new JButton("Second");

        firstButton.addActionListener(this);
        secondButton.addActionListener(this);

        jFrame.add(firstButton);
        jFrame.add(secondButton);

        jLabel = new JLabel("Press a button...");
        jFrame.add(jLabel);

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("First")) {
            jLabel.setText("First button was pressed");
        } else {
            jLabel.setText("Second button was pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
