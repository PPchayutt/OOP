/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dashboard extends JFrame {

    private ArrayList<Item> itemList;

    private JTable itemTable;
    private DefaultTableModel tableModel;
    private final JButton addButton;
    private final JButton editButton;
    private final JButton logoutButton;

    public Dashboard() {
        setTitle("Jisoo Shop - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 230, 250));

        loadItems();

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(230, 230, 250));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel welcomeLabel = new JLabel("Welcome to Jisoo Marketplace", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(75, 0, 130));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 250));

        addButton = new JButton("Add Item");
        editButton = new JButton("Edit Item");
        logoutButton = new JButton("Logout");

        styleButton(addButton);
        styleButton(editButton);
        styleButton(logoutButton);

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(logoutButton);

        topPanel.add(welcomeLabel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.CENTER);

        createTable();
        JScrollPane scrollPane = new JScrollPane(itemTable);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addEventListeners();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(147, 112, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private void createTable() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Created_On");

        itemTable = new JTable(tableModel);

        itemTable.getTableHeader().setBackground(new Color(147, 112, 219));
        itemTable.getTableHeader().setForeground(Color.WHITE);

        updateTableData();
    }

    private void updateTableData() {
        tableModel.setRowCount(0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Item item : itemList) {
            tableModel.addRow(new Object[]{
                item.getId(),
                item.getName(),
                item.getPrice(),
                dateFormat.format(item.getCreated_on())
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void loadItems() {
        File file = new File("jisoo_shop.dat");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                itemList = (ArrayList<Item>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                itemList = new ArrayList<>();
                createSampleData();
            }
        } else {
            itemList = new ArrayList<>();
            createSampleData();
            saveItems();
        }
    }

    private void saveItems() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jisoo_shop.dat"))) {
            oos.writeObject(itemList);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createSampleData() {
        Date currentDate = new Date();

        itemList.add(new Item(1, "Flower", 1150.0, currentDate));
        itemList.add(new Item(2, "Robux", 94.0, currentDate));
        itemList.add(new Item(3, "CD", 1100.0, currentDate));
        itemList.add(new Item(4, "Book", 50.0, currentDate));
    }

    private void addEventListeners() {
        addButton.addActionListener((ActionEvent e) -> {
            new AddItemFrame(Dashboard.this);
        });

        editButton.addActionListener((ActionEvent e) -> {
            int selectedRow = itemTable.getSelectedRow();
            if (selectedRow >= 0) {
                new EditItemFrame(Dashboard.this, selectedRow);
            } else {
                JOptionPane.showMessageDialog(Dashboard.this, "Please select item to update", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        logoutButton.addActionListener((ActionEvent e) -> {
            logout();
        });
    }

    private void logout() {
        dispose();
        new LoginFrame();
    }

    public void addItem(Item item) {
        itemList.add(item);
        saveItems();
        updateTableData();
    }

    public void updateItem(int index, Item updatedItem) {
        if (index >= 0 && index < itemList.size()) {
            itemList.set(index, updatedItem);
            saveItems();
            updateTableData();
        }
    }

    public void deleteItem(int index) {
        if (index >= 0 && index < itemList.size()) {
            itemList.remove(index);
            saveItems();
            updateTableData();
        }
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
}
