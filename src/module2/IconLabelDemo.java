package module2;

import javax.swing.*;
import java.awt.*;

public class IconLabelDemo {

    public IconLabelDemo() {
        JFrame frame = new JFrame("Use Image in Labels");
        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(250, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("recourses/icon.png");
        JLabel label = new JLabel(icon);

        JLabel labelIconText1 = new JLabel("Default Icon and Text Position", icon, SwingConstants.CENTER);
        JLabel labelIconText2 = new JLabel("Text Left of Icon", icon, SwingConstants.CENTER);
        labelIconText2.setHorizontalTextPosition(SwingConstants.LEFT);

        JLabel labelIconText3 = new JLabel("Text Over Icon", icon, SwingConstants.CENTER);
        labelIconText3.setVerticalTextPosition(SwingConstants.TOP);
        labelIconText3.setHorizontalTextPosition(SwingConstants.CENTER);

        frame.add(label);
        frame.add(labelIconText1);
        frame.add(labelIconText2);
        frame.add(labelIconText3);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IconLabelDemo();
            }
        });
    }
}
