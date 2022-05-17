package module3;

import javax.swing.*;
import java.awt.*;

public class CustomSBDemo {

    JLabel labelVertical;
    JLabel labelHorizontal;
    JLabel labelVSBInfo;
    JLabel labelHSBInfo;

    JScrollBar scrollBarVertical;
    JScrollBar scrollBarHorizontal;

    public CustomSBDemo() {
        JFrame frame = new JFrame("Scroll Bars Properties");
        frame.setLayout(new FlowLayout());
        frame.setSize(260, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelVertical = new JLabel("Value of vertical scroll bar: 0");
        labelHorizontal = new JLabel("Value of horizontal scroll bar: 250");

        scrollBarVertical = new JScrollBar(JScrollBar.VERTICAL, 0, 5, 0, 500);
        scrollBarHorizontal = new JScrollBar(JScrollBar.HORIZONTAL, 250, 0, 0, 500);

        scrollBarVertical.setPreferredSize(new Dimension(30, 200));
        scrollBarHorizontal.setPreferredSize(new Dimension(200, 10));
        scrollBarHorizontal.setBlockIncrement(25);

        scrollBarVertical.addAdjustmentListener(e -> {
            if (scrollBarVertical.getValueIsAdjusting()) {
                return;
            }
            labelVertical.setText("Value of vertical scroll bar: " + e.getValue());
        });

        scrollBarHorizontal.addAdjustmentListener(e ->
                labelHorizontal.setText("Value of horizontal scroll bar: " + e.getValue()));

        labelVSBInfo = new JLabel(
                "<html>Vertical Scroll Bar information<br>" +
                        "Minimum value: " + scrollBarVertical.getMinimum() + "<br>" +
                        "Maximum value: " + scrollBarVertical.getMaximum() + "<br>" +
                        "Visible amount (extent): " + scrollBarVertical.getVisibleAmount() + "<br>" +
                        "Block increment: " + scrollBarVertical.getBlockIncrement() + "<br>" +
                        "Unit increment: " + scrollBarVertical.getUnitIncrement()
        );

        labelHSBInfo = new JLabel(
                "<html>Vertical Scroll Bar information<br>" +
                        "Minimum value: " + scrollBarHorizontal.getMinimum() + "<br>" +
                        "Maximum value: " + scrollBarHorizontal.getMaximum() + "<br>" +
                        "Visible amount (extent): " + scrollBarHorizontal.getVisibleAmount() + "<br>" +
                        "Block increment: " + scrollBarHorizontal.getBlockIncrement() + "<br>" +
                        "Unit increment: " + scrollBarHorizontal.getUnitIncrement()
        );

        frame.add(scrollBarVertical);
        frame.add(scrollBarHorizontal);
        frame.add(labelVertical);
        frame.add(labelHorizontal);
        frame.add(labelVSBInfo);
        frame.add(labelHSBInfo);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomSBDemo::new);
    }
}
