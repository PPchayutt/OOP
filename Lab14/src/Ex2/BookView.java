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
import java.io.*;
import java.util.ArrayList;

public class BookView extends JFrame {

    private ArrayList<Book> books;
    private int currentIndex;
    private JTextField nameField, priceField, indexField;
    private JComboBox<String> typeComboBox;
    private JButton prevButton, nextButton, addButton, updateButton, deleteButton;

    public BookView() {
        books = new ArrayList<>();
        currentIndex = 0;
        setTitle("BookView");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        createGUI();
        addEventListeners();
        loadData();
        if (!books.isEmpty()) {
            displayBook();
        }
    }

    private void createGUI() {
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JPanel navigationPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        JLabel priceLabel = new JLabel("Price");
        JLabel typeLabel = new JLabel("Type");
        nameField = new JTextField(20);
        priceField = new JTextField(20);
        indexField = new JTextField("1", 5);
        indexField.setHorizontalAlignment(JTextField.CENTER);
        String[] types = {"General", "Computer", "Math&Sci", "Photo"};
        typeComboBox = new JComboBox<>(types);
        prevButton = new JButton("<<<");
        nextButton = new JButton(">>>");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        topPanel.add(nameLabel);
        topPanel.add(nameField);
        topPanel.add(priceLabel);
        topPanel.add(priceField);
        topPanel.add(typeLabel);
        topPanel.add(typeComboBox);
        navigationPanel.add(prevButton);
        navigationPanel.add(indexField);
        navigationPanel.add(nextButton);
        bottomPanel.add(addButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(deleteButton);
        add(topPanel, BorderLayout.NORTH);
        add(navigationPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void addEventListeners() {
        addButton.addActionListener((ActionEvent e) -> {
            BookAdd bookAdd = new BookAdd(BookView.this);
            bookAdd.setVisible(true);
        });
        updateButton.addActionListener((ActionEvent e) -> {
            updateBook();
        });
        deleteButton.addActionListener((ActionEvent e) -> {
            deleteBook();
        });
        prevButton.addActionListener((ActionEvent e) -> {
            if (!books.isEmpty() && currentIndex > 0) {
                currentIndex--;
                displayBook();
            }
        });
        nextButton.addActionListener((ActionEvent e) -> {
            if (!books.isEmpty() && currentIndex < books.size() - 1) {
                currentIndex++;
                displayBook();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!books.isEmpty()) {
                    saveData();
                }
            }
        });
    }

    public void addBook(Book book) {
        books.add(book);
        currentIndex = books.size() - 1;
        displayBook();
        JOptionPane.showMessageDialog(this, "Done it.", "Insert Command", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateBook() {
        if (!books.isEmpty()) {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                String type = (String) typeComboBox.getSelectedItem();
                Book book = books.get(currentIndex);
                book.setName(name);
                book.setPrice(price);
                book.setType(type);
                JOptionPane.showMessageDialog(this, "Done it.", "Update Command", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Price must be number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteBook() {
        if (!books.isEmpty()) {
            books.remove(currentIndex);
            if (currentIndex >= books.size()) {
                currentIndex = Math.max(0, books.size() - 1);
            }
            if (!books.isEmpty()) {
                displayBook();
            } else {
                nameField.setText("");
                priceField.setText("");
                indexField.setText("1");
            }
            JOptionPane.showMessageDialog(this, "Done it.", "Delete Command", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayBook() {
        if (!books.isEmpty() && currentIndex >= 0 && currentIndex < books.size()) {
            Book book = books.get(currentIndex);
            nameField.setText(book.getName());
            priceField.setText(String.valueOf(book.getPrice()));
            typeComboBox.setSelectedItem(book.getType());
            indexField.setText(String.valueOf(currentIndex + 1));
        }
    }

    private void saveData() {
        try {
            try (FileOutputStream fileOut = new FileOutputStream("Book.data"); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(books);
            }
        } catch (IOException e) {
        }
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        try {
            File file = new File("Book.data");
            if (file.exists()) {
                try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    books = (ArrayList<Book>) in.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookView bookView = new BookView();
            bookView.setVisible(true);
        });
    }
}
