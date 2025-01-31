/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Ex6;

/**
 *
 * @author pitch
 */
import javax.swing.*;
import java.awt.*;

public class MDIFromGUI {
    private JFrame fr;
    private JDesktopPane dp;
    private JMenuBar mb;
    private JMenu m1, m2, m3, m4;
    private JMenuItem mi1, mi2, mi3, mi4, mi5;
    
    public MDIFromGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        fr = new JFrame("SubMenuItem Demo");
        dp = new JDesktopPane();
        dp.setBackground(Color.BLACK);
        
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        m4 = new JMenu("New");
        
        mi1 = new JMenuItem("Window");
        mi2 = new JMenuItem("Message");
        mi3 = new JMenuItem("Open");
        mi4 = new JMenuItem("Save");
        mi5 = new JMenuItem("Exit");
        
        m4.add(mi1);
        m4.addSeparator();
        m4.add(mi2);
        
        m1.add(m4);
        m1.add(mi3);
        m1.addSeparator();
        m1.add(mi4);
        m1.addSeparator();
        m1.add(mi5);
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
        JInternalFrame f1 = new JInternalFrame("Application 01", true, true, true, true);
        JInternalFrame f2 = new JInternalFrame("Application 02", true, true, true, true);
        JInternalFrame f3 = new JInternalFrame("Application 03", true, true, true, true);
        
        f1.setSize(200, 150);
        f2.setSize(200, 150);
        f3.setSize(200, 150);
        
        f1.setLocation(100, 100);
        f2.setLocation(200, 200);
        f3.setLocation(300, 300);
        
        f1.setVisible(true);
        f2.setVisible(true);
        f3.setVisible(true);
        
        dp.add(f1);
        dp.add(f2);
        dp.add(f3);
        
        fr.setJMenuBar(mb);
        fr.add(dp);
        fr.setSize(800, 600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}