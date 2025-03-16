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
import java.util.ArrayList;

public class EditItemFrame extends JFrame {

    private final JTextField idField;
    private final JTextField nameField;
    private final JTextField priceField;
    private final JButton prevButton;
    private final JButton nextButton;
    private final JButton deleteButton;
    private final JButton updateButton;
    private final JButton closeButton;

    private final Dashboard dashboard;
    private final ArrayList<Item> itemList;
    private int currentIndex;

    public EditItemFrame(Dashboard dashboard, int selectedIndex) {
        this.dashboard = dashboard;
        this.itemList = dashboard.getItemList();
        this.currentIndex = selectedIndex;

        setTitle("Edit Item");
        setSize(350, 250);
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

        JPanel navigationPanel = new JPanel();
        navigationPanel.setBackground(new Color(230, 230, 250));

        prevButton = new JButton("<<");
        nextButton = new JButton(">>");

        styleButton(prevButton);
        styleButton(nextButton);

        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 250));

        deleteButton = new JButton("Delete Item");
        updateButton = new JButton("Update Item");
        closeButton = new JButton("Close Item");

        styleButton(deleteButton);
        styleButton(updateButton);
        styleButton(closeButton);

        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(closeButton);

        add(mainPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        displayCurrentItem();

        addEventListeners();

        setLocationRelativeTo(dashboard);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(147, 112, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private void displayCurrentItem() {
        if (!itemList.isEmpty() && currentIndex >= 0 && currentIndex < itemList.size()) {
            Item currentItem = itemList.get(currentIndex);

            idField.setText(String.valueOf(currentItem.getId()));
            nameField.setText(currentItem.getName());
            priceField.setText(String.valueOf(currentItem.getPrice()));
        }
    }

    private void addEventListeners() {
        // เมื่อกดปุ่ม Previous
        prevButton.addActionListener((ActionEvent e) -> {
            if (currentIndex > 0) {
                currentIndex--;
            } else {
                currentIndex = 0;
            }
            displayCurrentItem();
        });

        nextButton.addActionListener((ActionEvent e) -> {
            if (currentIndex < itemList.size() - 1) {
                currentIndex++;
            } else {
                currentIndex = itemList.size() - 1;
            }
            displayCurrentItem();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            deleteItem();
        });

        updateButton.addActionListener((ActionEvent e) -> {
            updateItem();
        });

        closeButton.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }

    private void deleteItem() {
        if (!itemList.isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this item?",
                    "Confirm delete",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                dashboard.deleteItem(currentIndex);

                JOptionPane.showMessageDialog(this, "Done it.", "Delete Success", JOptionPane.INFORMATION_MESSAGE);

                dispose();
            }
        }
    }

    private void updateItem() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please input item name", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Item updatedItem = new Item(
                    id,
                    name,
                    price,
                    itemList.get(currentIndex).getCreated_on()
            );

            dashboard.updateItem(currentIndex, updatedItem);

            JOptionPane.showMessageDialog(this, "Done it.", "Update Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please input correct number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
