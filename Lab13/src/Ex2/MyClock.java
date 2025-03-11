package Ex2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author OPTO
 */
import javax.swing.JLabel;
import javax.swing.*;
import java.util.Calendar;

public class MyClock extends JLabel implements Runnable {

    public MyClock() {
        super();
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void run() {
        while (true) {
            Calendar d = Calendar.getInstance();

            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);

            String time = String.format("%02d:%02d:%02d", hour, min, sec);
            setText(time);
            setFont(new java.awt.Font("Courier New", java.awt.Font.PLAIN, 70));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
