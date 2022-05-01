package modul1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Coder implements ActionListener {
    private static final String ENCODE = "Encode";
    private static final String DECODE = "Decode";

    JTextField plainText;
    JTextField cipherText;

    public Coder() {
        JFrame frame = new JFrame("A simple code machine");
        frame.setLayout(new FlowLayout());
        frame.setSize(340, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelPlainText = new JLabel("Plain text: ");
        JLabel labelCipherText = new JLabel("Cipher text: ");

        plainText = new JTextField(20);
        cipherText = new JTextField(20);

        plainText.setActionCommand(ENCODE);
        cipherText.setActionCommand(DECODE);

        plainText.addActionListener(this);
        cipherText.addActionListener(this);

        frame.add(labelPlainText);
        frame.add(plainText);
        frame.add(labelCipherText);
        frame.add(cipherText);

        JButton encodeButton = new JButton(ENCODE);
        JButton decodeButton = new JButton(DECODE);
        JButton resetButton = new JButton("Reset");

        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.add(encodeButton);
        frame.add(decodeButton);
        frame.add(resetButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ENCODE)) {
            StringBuilder stringBuilder = new StringBuilder(plainText.getText());
            for (int i = 0; i < stringBuilder.length(); i++) {
                stringBuilder.setCharAt(i, (char)(stringBuilder.charAt(i) + 1));
            }
            cipherText.setText(stringBuilder.toString());
        } else if (e.getActionCommand().equals(DECODE)) {
            StringBuilder stringBuilder = new StringBuilder(cipherText.getText());
            for (int i = 0; i < stringBuilder.length(); i++) {
                stringBuilder.setCharAt(i, (char)(stringBuilder.charAt(i) - 1));
            }
            plainText.setText(stringBuilder.toString());
        } else {
            plainText.setText("");
            cipherText.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Coder();
            }
        });
    }
}
