/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex3;

/**
 *
 * @author pitch
 */
import javax.swing.*;
import java.awt.*;

public class CalculatorOneGUI {

    private JFrame fr;
    private JPanel p;
    private JTextField txt1, txt2, txt3;
    private JButton bn1, bn2, bn3, bn4;

    public CalculatorOneGUI() {
        fr = new JFrame("Calculator");
        p = new JPanel();
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        bn1 = new JButton("+");
        bn2 = new JButton("-");
        bn3 = new JButton("*");
        bn4 = new JButton("/");

        fr.setLayout(new GridLayout(4, 1));
        p.setLayout(new FlowLayout());

        p.add(bn1);
        p.add(bn2);
        p.add(bn3);
        p.add(bn4);

        fr.add(txt1);
        fr.add(txt2);
        fr.add(p);
        fr.add(txt3);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 200);
        fr.setVisible(true);
    }
}
