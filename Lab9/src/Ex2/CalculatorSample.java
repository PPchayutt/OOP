/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author pitch
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorSample implements ActionListener {

    private final JFrame fr;
    private final JPanel p;
    private final JTextField txt;
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JButton b4;
    private final JButton b5;
    private final JButton b6;
    private final JButton b7;
    private final JButton b8;
    private final JButton b9;
    private final JButton b10;
    private final JButton b11;
    private final JButton b12;
    private final JButton b13;
    private final JButton b14;
    private final JButton b15;
    private final JButton b16;
    private double firstNumber;
    private String operator;

    public CalculatorSample() {
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

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);

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

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("+") || command.equals("-")
                || command.equals("x") || command.equals("/")) {
            firstNumber = Double.parseDouble(txt.getText());
            operator = command;
            txt.setText("");
        } else if (command.matches("[0-9]")) {
            String currentText = txt.getText();
            txt.setText(currentText + command);
        } else if (command.equals("c")) {
            txt.setText("");
            firstNumber = 0;
            operator = "";
        } else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(txt.getText());
            double result = 0;

            switch (operator) {
                case "+" ->
                    result = firstNumber + secondNumber;
                case "-" ->
                    result = firstNumber - secondNumber;
                case "x" ->
                    result = firstNumber * secondNumber;
                case "/" ->
                    result = firstNumber / secondNumber;
                default -> {
                }
            }

            txt.setText(String.valueOf(result));
        }
    }
}
