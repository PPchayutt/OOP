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
import java.awt.event.*;

public class TellerGUI implements ActionListener {

    private final JFrame fr;
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JLabel lb1;
    private final JLabel lb2;
    private final JTextField txt1;
    private final JTextField txt2;
    private final JButton bn1;
    private final JButton bn2;
    private final JButton bn3;
    private final Account account;

    public TellerGUI() {
        account = new Account(6000, "Account");

        fr = new JFrame("Teller GUI");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        lb1 = new JLabel("  Balance");
        lb2 = new JLabel("  Amount");
        txt1 = new JTextField(String.valueOf(account.getBalance()));
        txt2 = new JTextField();
        txt1.setEditable(false);
        bn1 = new JButton("Deposit");
        bn2 = new JButton("Withdraw");
        bn3 = new JButton("Exit");

        bn1.addActionListener(this);
        bn2.addActionListener(this);
        bn3.addActionListener(this);

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

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        double amount = 0;
        try {
            amount = Double.parseDouble(txt2.getText());
        } catch (NumberFormatException e) {
            return;
        }

        if (ae.getSource() == bn1) {
            account.deposit(amount);
            txt1.setText(String.valueOf(account.getBalance()));
        } else if (ae.getSource() == bn2) {
            if (amount <= account.getBalance()) {
                account.withdraw(amount);
                txt1.setText(String.valueOf(account.getBalance()));
            }
        } else if (ae.getSource() == bn3) {
            System.exit(0);
        }
    }
}
