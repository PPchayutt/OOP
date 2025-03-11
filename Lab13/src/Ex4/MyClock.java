package Ex4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author OPTO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyClock extends JLabel implements Runnable {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    private boolean isRunning = true;

    public MyClock() {
        super();
        setHorizontalAlignment(SwingConstants.CENTER);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isRunning) {
                    isRunning = false;
                } else {
                    isRunning = true;
                    synchronized (MyClock.this) {
                        MyClock.this.notify();
                    }
                }
            }
        });
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (!isRunning) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

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
