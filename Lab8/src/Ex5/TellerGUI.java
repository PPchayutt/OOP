/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex5;

/**
 *
 * @author pitch
 */
import javax.swing.*;
import java.awt.*;

public class TellerGUI {

    private JFrame fr;
    private JPanel p1, p2, p3;
    private JLabel lb1, lb2;
    private JTextField txt1, txt2;
    private JButton bn1, bn2, bn3;

    public TellerGUI() {
        fr = new JFrame("Teller GUI");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        lb1 = new JLabel("  Balance");
        lb2 = new JLabel("  Amount");

        txt1 = new JTextField("6000");
        txt2 = new JTextField();
        txt1.setEditable(false);

        bn1 = new JButton("Deposit");
        bn2 = new JButton("Withdraw");
        bn3 = new JButton("Exit");

        fr.setLayout(new GridLayout(4, 1));
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new FlowLayout());

        p1.add(lb1);
        p1.add(txt1);
        p2.add(lb2);
        p2.add(txt2);
        p3.add(bn1);
        p3.add(bn2);
        p3.add(bn3);

        fr.add(p1);
        fr.add(p2);
        fr.add(p3);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 200);
        fr.setVisible(true);
    }
}
