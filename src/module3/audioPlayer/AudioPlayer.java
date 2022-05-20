package module3.audioPlayer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Hashtable;

public class AudioPlayer implements ChangeListener {

    JLabel labelBass;
    JLabel labelMidrange;
    JLabel labelTreble;
    JLabel labelBalance;
    JLabel labelVolume;
    JLabel labelInfo;

    JSlider sliderBass;
    JSlider sliderMidrange;
    JSlider sliderTreble;
    JSlider sliderBalance;
    JSlider sliderVolume;

    JRadioButton radioButtonPreset1;
    JRadioButton radioButtonPreset2;
    JRadioButton radioButtonDefaults;

    JButton buttonStore;

    DecimalFormat decimalFormat;

    Presets[] presets;

    public AudioPlayer() {
        JFrame frame = new JFrame("A simple audio player GUI");
        frame.setLayout(new FlowLayout());
        frame.setSize(340, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        decimalFormat = new DecimalFormat("+#;-#");

        setupPresets();
        setupSliders();
        setupLabels();
        setupRButtons();

        buttonStore = new JButton("Store settings");

        sliderBass.addChangeListener(this);
        sliderMidrange.addChangeListener(this);
        sliderTreble.addChangeListener(this);
        sliderBalance.addChangeListener(this);
        sliderVolume.addChangeListener(this);

        buttonStore.addActionListener(e -> {
            if (radioButtonPreset1.isSelected()) {
                storePreset(presets[1]);
            } else if (radioButtonPreset2.isSelected()) {
                storePreset(presets[2]);
            }
        });

        radioButtonDefaults.addActionListener(e -> loadPreset(presets[0]));
        radioButtonPreset1.addActionListener(e -> loadPreset(presets[1]));
        radioButtonPreset2.addActionListener(e -> loadPreset(presets[2]));

        frame.add(labelBass);
        frame.add(sliderBass);
        frame.add(labelMidrange);
        frame.add(sliderMidrange);
        frame.add(labelTreble);
        frame.add(sliderTreble);
        frame.add(labelBalance);
        frame.add(sliderBalance);
        frame.add(labelVolume);
        frame.add(sliderVolume);
        frame.add(radioButtonDefaults);
        frame.add(radioButtonPreset1);
        frame.add(radioButtonPreset2);
        frame.add(buttonStore);
        frame.add(new JLabel(""));
        frame.add(labelInfo);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        showSettings();
    }

    private void showSettings() {
        String bal;

        int b = sliderBalance.getValue();
        if (b > 0) {
            bal = "Right " + decimalFormat.format(sliderBalance.getValue());
        } else if (b == 0) {
            bal = "Center";
        } else {
            bal = "Left " + decimalFormat.format(-sliderBalance.getValue());
        }

        labelInfo.setText(
                "<html>Treble: " + decimalFormat.format(sliderTreble.getValue()) + "<br>" +
                "<html>Midrange: " + decimalFormat.format(sliderMidrange.getValue()) + "<br>" +
                "<html>Bass: " + decimalFormat.format(sliderBass.getValue()) + "<br>" +
                "<html>Balance: " + bal + "<br>" +
                "<html>Volume: " + sliderVolume.getValue()

        );
    }

    private void setupSliders() {
        sliderBass = new JSlider(-10, 10);
        sliderMidrange = new JSlider(-10, 10);
        sliderTreble = new JSlider(-10, 10);
        sliderVolume = new JSlider(0, 10, 0);
        sliderBalance = new JSlider(-5, 5);

        sliderBass.setMajorTickSpacing(2);
        sliderMidrange.setMajorTickSpacing(2);
        sliderTreble.setMajorTickSpacing(2);
        sliderVolume.setMajorTickSpacing(1);
        sliderBalance.setMajorTickSpacing(1);

        sliderBass.setMinorTickSpacing(1);
        sliderMidrange.setMinorTickSpacing(1);
        sliderTreble.setMinorTickSpacing(1);

        Hashtable hashtable = new Hashtable();
        for (int i = -10; i <= 0; i +=2) {
            hashtable.put(new Integer(i), new JLabel("" + i));
        }
        for (int i = 2; i <= 10; i +=2) {
            hashtable.put(new Integer(i), new JLabel("+" + i));
        }
        sliderTreble.setLabelTable(hashtable);
        sliderMidrange.setLabelTable(hashtable);
        sliderVolume.setLabelTable(hashtable);

        hashtable = new Hashtable();
        hashtable.put(new Integer(0), new JLabel("Center"));
        hashtable.put(new Integer(-5), new JLabel("L"));
        hashtable.put(new Integer(5), new JLabel("R"));
        sliderBalance.setLabelTable(hashtable);

        sliderVolume.setLabelTable(sliderVolume.createStandardLabels(1));

        sliderBass.setPaintTicks(true);
        sliderMidrange.setPaintTicks(true);
        sliderTreble.setPaintTicks(true);
        sliderVolume.setPaintTicks(true);
        sliderBalance.setPaintTicks(true);

        sliderBass.setPaintLabels(true);
        sliderMidrange.setPaintLabels(true);
        sliderTreble.setPaintLabels(true);
        sliderVolume.setPaintLabels(true);
        sliderBalance.setPaintLabels(true);

        sliderBass.setSnapToTicks(true);
        sliderMidrange.setSnapToTicks(true);
        sliderTreble.setSnapToTicks(true);
        sliderVolume.setSnapToTicks(true);
        sliderBalance.setSnapToTicks(true);

        Dimension sliderSize = new Dimension(240, 60);
        sliderBass.setPreferredSize(sliderSize);
        sliderMidrange.setPreferredSize(sliderSize);
        sliderTreble.setPreferredSize(sliderSize);
        sliderVolume.setPreferredSize(sliderSize);
        sliderBalance.setPreferredSize(sliderSize);
    }

    private void setupLabels() {
        labelTreble = new JLabel("Treble");
        labelMidrange = new JLabel("Midrange");
        labelBass = new JLabel("Bass");
        labelVolume = new JLabel("Volume");
        labelBalance = new JLabel("Balance");

        Dimension labelSize = new Dimension(60, 25);
        labelTreble.setPreferredSize(labelSize);
        labelMidrange.setPreferredSize(labelSize);
        labelBass.setPreferredSize(labelSize);
        labelVolume.setPreferredSize(labelSize);
        labelBalance.setPreferredSize(labelSize);

        labelInfo = new JLabel("");
        labelInfo.setPreferredSize(new Dimension(110, 100));

        showSettings();
    }

    private void setupRButtons() {
        radioButtonDefaults = new JRadioButton("Defaults");
        radioButtonPreset1 = new JRadioButton("Preset 1");
        radioButtonPreset2 = new JRadioButton("Preset 2");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonDefaults);
        bg.add(radioButtonPreset1);
        bg.add(radioButtonPreset2);

        radioButtonDefaults.setSelected(true);
    }

    private void loadPreset(Presets info) {
        sliderBass.setValue(info.bass);
        sliderMidrange.setValue(info.midrange);
        sliderTreble.setValue(info.treble);
        sliderBalance.setValue(info.balance);
        sliderVolume.setValue(info.volume);
    }

    private void storePreset(Presets info) {
        info.bass = sliderBass.getValue();
        info.midrange = sliderMidrange.getValue();
        info.treble = sliderTreble.getValue();
        info.balance = sliderBalance.getValue();
        info.volume = sliderVolume.getValue();
    }

    private void setupPresets() {
        presets = new Presets[3];
        presets[0] = new Presets(0, 0, 0, 0, 0);
        presets[1] = new Presets(2, -4, 7, 0, 4);
        presets[2] = new Presets(3, 3, -2, 1, 7);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AudioPlayer::new);
    }
}
