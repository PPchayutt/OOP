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
import java.awt.event.*;
import java.util.Date;

public class AddItemFrame extends JFrame {

    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JButton insertButton;

    private final Dashboard dashboard;

    public AddItemFrame(Dashboard dashboard) {
        this.dashboard = dashboard;

        setTitle("Add New Item");
        setSize(300, 200);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 230, 250));

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 230, 250));

        JLabel idLabel = new JLabel("Id");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField();
        JLabel priceLabel = new JLabel("Price");
        priceField = new JTextField();

        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(priceLabel);
        mainPanel.add(priceField);

        insertButton = new JButton("Insert Item");
        insertButton.setBackground(new Color(147, 112, 219));
        insertButton.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 250));
        buttonPanel.add(insertButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        insertButton.addActionListener((ActionEvent e) -> {
            insertItem();
        });

        setLocationRelativeTo(dashboard);
        setVisible(true);
    }

    private void insertItem() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please input item name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Item newItem = new Item(id, name, price, new Date());

            dashboard.addItem(newItem);

            JOptionPane.showMessageDialog(this, "Done it.", "Success", JOptionPane.INFORMATION_MESSAGE);

            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please input correct number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
