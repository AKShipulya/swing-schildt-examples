package modul1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class StopWatch implements ActionListener {

    JLabel jLabel;
    long start;

    public StopWatch() {
        JFrame jFrame = new JFrame("A simple Stopwatch");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(230, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        jFrame.add(startButton);
        jFrame.add(stopButton);

        jLabel = new JLabel("Press start to begin timing...");
        jFrame.add(jLabel);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calendar calendar = Calendar.getInstance();

        if (e.getActionCommand().equals("Start")) {
            start = calendar.getTimeInMillis();
            jLabel.setText("Stopwatch is running...");
        } else {
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
