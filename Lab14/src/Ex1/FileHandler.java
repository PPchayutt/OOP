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
import java.io.*;

public class FileHandler {

    private final JFrame parentFrame;
    private final JTextArea textArea;

    public FileHandler(JFrame parentFrame, JTextArea textArea) {
        this.parentFrame = parentFrame;
        this.textArea = textArea;
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(parentFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                textArea.setText(content.toString());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        parentFrame,
                        "Error reading file: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void saveFile() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(parentFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
                writer.write(textArea.getText());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        parentFrame,
                        "Error saving file: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
