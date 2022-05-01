package module2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AlignLabelDemo {

    public AlignLabelDemo() {
        JLabel[] labels = new JLabel[9];

        JFrame frame = new JFrame("Horizontal and Vertical Alignment");
        frame.setLayout(new GridLayout(3, 3, 4, 4));
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labels[0] = new JLabel("Left, Top", SwingConstants.LEFT);
        labels[0].setVerticalAlignment(SwingConstants.TOP);
        labels[1] = new JLabel("Center, Top", SwingConstants.CENTER);
        labels[1].setVerticalAlignment(SwingConstants.TOP);
        labels[2] = new JLabel("Right, Top", SwingConstants.RIGHT);
        labels[2].setVerticalAlignment(SwingConstants.TOP);
        labels[3] = new JLabel("Left, Center", SwingConstants.LEFT);
        labels[3].setVerticalAlignment(SwingConstants.CENTER);
        labels[4] = new JLabel("Center, Center", SwingConstants.CENTER);
        labels[4].setVerticalAlignment(SwingConstants.CENTER);
        labels[5] = new JLabel("Right, Center", SwingConstants.RIGHT);
        labels[5].setVerticalAlignment(SwingConstants.CENTER);
        labels[6] = new JLabel("Left, Bottom", SwingConstants.LEFT);
        labels[6].setVerticalAlignment(SwingConstants.BOTTOM);
        labels[7] = new JLabel("Center, Bottom", SwingConstants.CENTER);
        labels[7].setVerticalAlignment(SwingConstants.BOTTOM);
        labels[8] = new JLabel("Right, Bottom", SwingConstants.RIGHT);
        labels[8].setVerticalAlignment(SwingConstants.BOTTOM);

        Border border = BorderFactory.createEtchedBorder();
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBorder(border);
        }
        for (int i = 0; i < labels.length; i++) {
            frame.add(labels[i]);
        }

        JPanel clearPanel = ((JPanel) frame.getContentPane());
        clearPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AlignLabelDemo();
            }
        });
    }
}
