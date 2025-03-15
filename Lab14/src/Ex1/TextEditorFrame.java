package Ex1;

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

public class TextEditorFrame extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newMenuItem, openMenuItem, saveMenuItem, closeMenuItem;
    private final FileHandler fileHandler;

    public TextEditorFrame() {
        setTitle("My Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initTextArea();

        fileHandler = new FileHandler(this, textArea);

        createMenus();

        setLocationRelativeTo(null);
    }

    private void initTextArea() {
        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void createMenus() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");

        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        closeMenuItem = new JMenuItem("Close");

        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        closeMenuItem.addActionListener(this);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(closeMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newMenuItem) {
            textArea.setText("");
        } else if (e.getSource() == openMenuItem) {
            fileHandler.openFile();
        } else if (e.getSource() == saveMenuItem) {
            fileHandler.saveFile();
        } else if (e.getSource() == closeMenuItem) {
            System.exit(0);
        }
    }
}
