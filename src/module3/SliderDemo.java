package module3;

import javax.swing.*;
import java.awt.*;

public class SliderDemo {

    JLabel labelVertical;
    JLabel labelHorizontal;

    JSlider sliderVertical;
    JSlider sliderHorizontal;

    public SliderDemo() {
        JFrame frame = new JFrame("Demonstrate sliders");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sliderVertical = new JSlider(JSlider.VERTICAL);
        sliderVertical.setSnapToTicks(true);
        sliderHorizontal = new JSlider();
        sliderHorizontal.setInverted(true);

        sliderVertical.setMajorTickSpacing(10);
        sliderHorizontal.setMajorTickSpacing(20);

        sliderVertical.setMinorTickSpacing(5);

        sliderVertical.setLabelTable(sliderVertical.createStandardLabels(10));
        sliderHorizontal.setLabelTable(sliderHorizontal.createStandardLabels(20));

        sliderVertical.setPaintLabels(true);
        sliderHorizontal.setPaintLabels(true);

        labelVertical = new JLabel("Value of vertical slider: " + sliderVertical.getValue());
        labelHorizontal = new JLabel("Value of horizontal slider: " + sliderHorizontal.getValue());

        sliderHorizontal.addChangeListener(e -> {
            if (sliderHorizontal.getValueIsAdjusting()) {
                return;
            }
            labelHorizontal.setText("Value of horizontal slider: " + sliderHorizontal.getValue());
        });

        sliderVertical.addChangeListener(e -> labelVertical.setText("Value of vertical slider: " + sliderVertical.getValue()));

        frame.add(sliderHorizontal);
        frame.add(sliderVertical);
        frame.add(labelHorizontal);
        frame.add(labelVertical);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SliderDemo::new);
    }
}
