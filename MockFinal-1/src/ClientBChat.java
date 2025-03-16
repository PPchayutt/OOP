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
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class ClientBChat extends JFrame implements ActionListener, WindowListener {

    private final JTextArea chatArea;
    private final JTextField messageField;
    private final JButton sendButton;
    private final String sender = "B";
    private Timer chatUpdateTimer;
    private long lastModified = 0;

    public ClientBChat() {
        setTitle("Chatbox (Fake Websocket) - Client B");
        setSize(400, 300);
        setLocation(450, 0);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        sendButton = new JButton("Send");

        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(this);
        messageField.addActionListener(this);
        addWindowListener(this);

        loadChatHistory();

        setupChatUpdateTimer();

        setVisible(true);
    }

    private void setupChatUpdateTimer() {
        chatUpdateTimer = new Timer();
        chatUpdateTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkForUpdates();
            }
        }, 0, 500);
    }

    private void checkForUpdates() {
        File file = new File("chat_history.dat");
        if (file.exists() && file.lastModified() > lastModified) {
            lastModified = file.lastModified();
            loadChatHistory();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton || e.getSource() == messageField) {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String timestamp = dtf.format(LocalDateTime.now());
                String fullMessage = "[" + timestamp + "] " + sender + ": " + message + "\n";

                String existingText = "";
                File file = new File("chat_history.dat");
                if (file.exists()) {
                    try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        existingText = content.toString();
                    } catch (IOException ex) {
                        System.err.println("Error reading chat history: " + ex.getMessage());
                    }
                }

                String updatedText = existingText + fullMessage;
                try (FileWriter fileWriter = new FileWriter("chat_history.dat"); BufferedWriter writer = new BufferedWriter(fileWriter)) {
                    writer.write(updatedText);
                } catch (IOException ex) {
                    System.err.println("Error saving chat history: " + ex.getMessage());
                }

                loadChatHistory();

                messageField.setText("");
                messageField.requestFocus();
            }
        }
    }

    private void loadChatHistory() {
        File file = new File("chat_history.dat");
        if (file.exists()) {
            lastModified = file.lastModified();
            try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("] " + sender + ": ")) {
                        int insertIndex = line.indexOf(sender + ": ");
                        line = line.substring(0, insertIndex + sender.length())
                                + " (You)" + line.substring(insertIndex + sender.length());
                    }
                    content.append(line).append("\n");
                }

                chatArea.setText(content.toString());
                chatArea.setCaretPosition(chatArea.getDocument().getLength());
            } catch (IOException ex) {
                System.err.println("Error loading chat history: " + ex.getMessage());
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        chatUpdateTimer.cancel();
        dispose();
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
