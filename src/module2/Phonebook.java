package module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Phonebook {

    JTextField textFieldName;
    JTextField textFieldNumber;

    JRadioButton radioButtonExact;
    JRadioButton radioButtonStartsWith;
    JRadioButton radioButtonEndsWith;

    JCheckBox checkBoxIgnoreCase;

    //List of names and numbers
    String[][] phoneList = {
            {"Jon", "555-8765"},
            {"Jessica", "555-5643"},
            {"Adam", "555-1212"},
            {"Rachel", "555-3435"},
            {"Tom & Jerry", "555-1001"}
    };

    public Phonebook() {
        JFrame frame = new JFrame("A Simple Phone List");
        frame.setLayout(new GridLayout(0, 1));
        frame.setSize(240, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelName = new JLabel("Name");
        JLabel labelNumber = new JLabel("Number");
        JLabel labelOptions = new JLabel("Search Options");

        textFieldName = new JTextField(10);
        textFieldNumber = new JTextField(10);

        checkBoxIgnoreCase = new JCheckBox("Ignore case");
        radioButtonExact = new JRadioButton("Exact match", true);
        radioButtonStartsWith = new JRadioButton("Starts with");
        radioButtonEndsWith = new JRadioButton("Ends with");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonExact);
        bg.add(radioButtonStartsWith);
        bg.add(radioButtonEndsWith);

        textFieldName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNumber.setText(lookupName(textFieldName.getText()));
            }
        });
        textFieldNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText(lookupNumber(textFieldNumber.getText()));
            }
        });

        frame.add(labelName);
        frame.add(textFieldName);
        frame.add(labelNumber);
        frame.add(textFieldNumber);
        frame.add(new JLabel());
        frame.add(labelOptions);
        frame.add(checkBoxIgnoreCase);
        frame.add(new JLabel());
        frame.add(radioButtonExact);
        frame.add(radioButtonStartsWith);
        frame.add(radioButtonEndsWith);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private String lookupName(String name) {
        for (int i = 0; i < phoneList.length; i++) {
            if (radioButtonStartsWith.isSelected()) {
                if (checkBoxIgnoreCase.isSelected()) {
                    if (phoneList[i][0].toLowerCase().startsWith(name.toLowerCase())) {
                        return phoneList[i][1];
                    }
                } else {
                    if (phoneList[i][0].startsWith(name)) {
                        return phoneList[i][1];
                    }
                }
            } else if (radioButtonEndsWith.isSelected()) {
                if (checkBoxIgnoreCase.isSelected()) {
                    if (phoneList[i][0].toLowerCase().endsWith(name.toLowerCase())) {
                        return phoneList[i][1];
                    }
                } else {
                    if (phoneList[i][0].endsWith(name)) {
                        return phoneList[i][1];
                    }
                }
            } else {
                if (checkBoxIgnoreCase.isSelected()) {
                    if (phoneList[i][0].equalsIgnoreCase(name.toLowerCase())) {
                        return phoneList[i][1];
                    }
                } else {
                    if (phoneList[i][0].equals(name)) {
                        return phoneList[i][1];
                    }
                }
            }
        }
        return "Not Found";
    }

    private String lookupNumber(String number) {
        for (int i = 0; i < phoneList.length; i++) {
            if (radioButtonStartsWith.isSelected() && phoneList[i][1].contains(number) || radioButtonEndsWith.isSelected() && phoneList[i][1].contains(number)) {
                return phoneList[i][0];
            } else {
                if (radioButtonExact.isSelected() && phoneList[i][1].equals(number)) {
                    return phoneList[i][0];
                }
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Phonebook();
            }
        });
    }

}
