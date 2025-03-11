/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author OPTO
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Poring extends Thread {

    private JFrame frame;
    private JLabel label;
    private static int poringCount = 0;
    private boolean isShaking = true;

    public Poring() {
        this.start();
    }

    @Override
    public void run() {
        frame = new JFrame("Poring");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setResizable(false);

        label = new JLabel("" + (++poringCount), SwingConstants.RIGHT);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        ImageIcon originalIcon = new ImageIcon("poring.png");
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        label.setIcon(scaledIcon);
        frame.add(label, BorderLayout.CENTER);

        setRandomLocation();

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isShaking = false;
                frame.dispose();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            }
        });

        frame.setVisible(true);

        startShaking();
    }

    private void setRandomLocation() {
        Random rand = new Random();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int randomX = rand.nextInt(screenSize.width - frame.getWidth());
        int randomY = rand.nextInt(screenSize.height - frame.getHeight());

        frame.setLocation(randomX, randomY);
    }

    private void startShaking() {
        Point originalLocation = frame.getLocation();
        Random rand = new Random();

        while (isShaking) {
            int xOffset = rand.nextInt(5) - 2;
            int yOffset = rand.nextInt(5) - 2;

            frame.setLocation(originalLocation.x + xOffset, originalLocation.y + yOffset);

            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            frame.setLocation(originalLocation);

            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
