/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author OPTO
 */
import javax.swing.*;

public class MyFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        frame.add(clock);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
