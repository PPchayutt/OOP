/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author OPTO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoringConstructor {

    private final JFrame frame;
    private final JButton addButton;

    public PoringConstructor() {
        frame = new JFrame("Poring Constructor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(150, 80);
        frame.setResizable(false);

        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.PLAIN, 12));
        addButton.setPreferredSize(new Dimension(60, 25));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Poring();
            }
        });

        frame.setLayout(new GridBagLayout());
        frame.add(addButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
