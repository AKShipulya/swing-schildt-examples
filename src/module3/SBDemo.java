package module3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class SBDemo {

    JLabel labelVertical;
    JLabel labelHorizontal;
    JLabel labelSBInfo;

    JScrollBar scrollBarVertical;
    JScrollBar scrollBarHorizontal;

    public SBDemo() {
        JFrame frame = new JFrame("Demonstrate Scroll Bars");
        frame.setLayout(new FlowLayout());
        frame.setSize(260, 260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelVertical = new JLabel("Value of vertical scroll bar: 0");
        labelHorizontal = new JLabel("Value of horizontal scroll bar: 0");

        scrollBarVertical = new JScrollBar();
        scrollBarVertical.setMaximum(110);
        scrollBarHorizontal = new JScrollBar(Adjustable.HORIZONTAL);
        scrollBarHorizontal.setMaximum(110);

        scrollBarVertical.addAdjustmentListener(e -> {
            if (scrollBarVertical.getValueIsAdjusting()) {
                return;
            }
            labelVertical.setText("Value of vertical scroll bar: " + e.getValue());
        });

        scrollBarHorizontal.addAdjustmentListener(e ->
                labelHorizontal.setText("Value of horizontal scroll bar: " + e.getValue()));

        labelSBInfo = new JLabel(
                "<html>Scroll Bar Defaults<br>" +
                        "Minimum value: " + scrollBarHorizontal.getMinimum() + "<br>" +
                        "Maximum value: " + scrollBarHorizontal.getMaximum() + "<br>" +
                        "Visible amount: " + scrollBarVertical.getVisibleAmount() + "<br>" +
                        "Block increment: " + scrollBarVertical.getBlockIncrement() + "<br>" +
                        "Unit increment: " + scrollBarVertical.getUnitIncrement()
        );

        frame.add(scrollBarVertical);
        frame.add(scrollBarHorizontal);
        frame.add(labelVertical);
        frame.add(labelHorizontal);
        frame.add(labelSBInfo);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SBDemo::new);
    }
}
