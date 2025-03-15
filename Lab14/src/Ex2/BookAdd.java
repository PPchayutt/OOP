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

public class BookAdd extends JFrame {

    private JTextField nameField, priceField;
    private JComboBox<String> typeComboBox;
    private final JButton insertButton;
    private BookView parentFrame;

    public BookAdd(BookView parent) {
        this.parentFrame = parent;
        setTitle("BookAdd");
        setSize(300, 150);
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel nameLabel = new JLabel("Name");
        JLabel priceLabel = new JLabel("Price");
        JLabel typeLabel = new JLabel("Type");
        nameField = new JTextField(20);
        priceField = new JTextField(20);
        String[] types = {"General", "Computer", "Math&Sci", "Photo"};
        typeComboBox = new JComboBox<>(types);
        insertButton = new JButton("Insert");
        insertButton.setPreferredSize(new Dimension(80, 25));
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(priceLabel);
        mainPanel.add(priceField);
        mainPanel.add(typeLabel);
        mainPanel.add(typeComboBox);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        insertButton.addActionListener((ActionEvent e) -> {
            try {
                String name1 = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String type1 = (String) typeComboBox.getSelectedItem();
                Book book = new Book(name1, price, type1);
                parentFrame.addBook(book);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(BookAdd.this,
                        "Price must be number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        setLocationRelativeTo(parent);
    }
}
