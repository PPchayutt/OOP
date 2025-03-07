/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author pitch
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatDemo implements ActionListener, WindowListener {

    JFrame frame;
    JTextArea textArea;
    JTextField textField;
    JButton submit, reset;

    public ChatDemo() {
        frame = new JFrame("ChatDemo");
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setColumns(45);
        textArea.setRows(20);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textField = new JTextField(45);
        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);
        textArea.setFont(thaiFont);
        textField.setFont(thaiFont);

        submit = new JButton("Submit");
        reset = new JButton("Reset");

        submit.addActionListener(this);
        reset.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submit);
        buttonPanel.add(reset);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(textField, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.addWindowListener(this);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(500, 400);

        loadHistory();

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String message = textField.getText();
            if (!message.isEmpty()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String timestamp = dtf.format(LocalDateTime.now());
                textArea.append(timestamp + " : " + message + "\n");
                textField.setText("");
            }
        } else if (e.getSource() == reset) {
            textArea.setText("");
        }
    }

    private void saveHistory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ChatDemo.dat"))) {
            oos.writeObject(textArea.getText());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadHistory() {
        File file = new File("ChatDemo.dat");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                String history = (String) ois.readObject();
                textArea.setText(history);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        saveHistory();
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
