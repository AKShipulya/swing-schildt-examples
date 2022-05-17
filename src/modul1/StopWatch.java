package modul1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class StopWatch implements ActionListener {

    JButton startButton;
    JButton stopButton;

    JLabel jLabel;
    long start;

    public StopWatch() {
        JFrame jFrame = new JFrame("A simple Stopwatch");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(230, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        stopButton.setEnabled(false);

        jFrame.add(startButton);
        jFrame.add(stopButton);

        jLabel = new JLabel("Press start to begin timing...");
        jFrame.add(jLabel);

        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calendar calendar = Calendar.getInstance();

        if (e.getActionCommand().equals("Start")) {
            start = calendar.getTimeInMillis();
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            jLabel.setText("Stopwatch is running...");
        } else {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            jLabel.setText("Elapsed time is " + (double) (calendar.getTimeInMillis() - start) / 1000);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StopWatch();
            }
        });
    }
}
