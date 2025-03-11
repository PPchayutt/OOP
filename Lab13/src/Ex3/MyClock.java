package Ex3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author OPTO
 */
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.*;

public class MyClock extends JLabel implements Runnable {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public MyClock() {
        super();
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void run() {
        while (true) {
            String time = String.format("%02d:%02d:%02d", hour, minute, second);
            setText(time);
            setFont(new Font("Courier New", Font.PLAIN, 70));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            second++;
            if (second == 60) {
                second = 0;
                minute++;
            }
            if (minute == 60) {
                minute = 0;
                hour++;
            }
        }
    }
}
