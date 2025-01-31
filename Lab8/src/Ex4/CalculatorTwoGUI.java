package Ex4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pitch
 */
import javax.swing.*;
import java.awt.*;

public class CalculatorTwoGUI {

    private JFrame fr;
    private JPanel p;
    private JTextField txt;
    private JButton b1, b2, b3, b4;
    private JButton b5, b6, b7, b8;
    private JButton b9, b10, b11, b12;
    private JButton b13, b14, b15, b16;

    public CalculatorTwoGUI() {
        fr = new JFrame("My Calculator");
        p = new JPanel();
        txt = new JTextField();

        b1 = new JButton("7");
        b2 = new JButton("8");
        b3 = new JButton("9");
        b4 = new JButton("+");
        b5 = new JButton("4");
        b6 = new JButton("5");
        b7 = new JButton("6");
        b8 = new JButton("-");
        b9 = new JButton("1");
        b10 = new JButton("2");
        b11 = new JButton("3");
        b12 = new JButton("x");
        b13 = new JButton("0");
        b14 = new JButton("c");
        b15 = new JButton("=");
        b16 = new JButton("/");

        fr.setLayout(new BorderLayout());
        p.setLayout(new GridLayout(4, 4));

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);
        p.add(b16);

        fr.add(txt, BorderLayout.NORTH);
        fr.add(p, BorderLayout.CENTER);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true);
    }
}
