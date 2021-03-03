package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Transforms2D extends JPanel {

    private class Display extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.translate(300,300);  // Moves (0,0) to the center of the display.
            int whichTransform = transformSelect.getSelectedIndex();

            // TODO Apply transforms here, depending on the value of whichTransform!
            g2.setStroke(new BasicStroke(20));
            AffineTransform old = g2.getTransform();
            // MY TRANSFORMATION:
            for (int i = 0; i < n; i++)
                myPolygon.addPoint((int) (150 * Math.cos(i * 2 * Math.PI / n)),
                        (int) (150 * Math.sin(i * 2 * Math.PI / n)));

            if (whichTransform == 1)
            {
                g2.scale(0.5,0.5);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 2)
            {
                g2.rotate(Math.toRadians(45));
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 3)
            {

                g2.rotate(Math.toRadians(180));
                g2.scale(-0.5,1);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 4)
            {
                g2.shear(0.3,0);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 5)
            {
                g2.scale(0.8,0.3);
                g2.translate(0,-830);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 6)
            {
                g2.rotate(Math.toRadians(90));
                g2.shear(0.5,0);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 7)
            {
                g2.rotate(Math.toRadians(180));
                g2.scale(0.5,1.2);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 8)
            {
                g2.rotate(Math.toRadians(40));
                g2.translate(0,100);
                g2.scale(1,0.5);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else if (whichTransform == 9)
            {
                g2.translate(130,0);
                g2.rotate(Math.toRadians(207));
                g2.shear(0.5,0);
                g2.drawPolygon(myPolygon);
                //g2.drawImage(pic,-200,-150,null);
                g2.setTransform(old);
            }
            else
            {
                //g2.drawImage(pic,-200,-150,null);
                g2.drawPolygon(myPolygon);
            }
        }
    }

    private Display display;
    private BufferedImage pic;
    private JComboBox<String> transformSelect;
    // MY VARIABLES
    private int n = 10;
    private Polygon myPolygon = new Polygon();
    public Transforms2D() throws IOException {
        pic = ImageIO.read(getClass().getClassLoader().getResource("img/shuttle.jpg"));
        display = new Display();
        display.setBackground(Color.YELLOW);
        display.setPreferredSize(new Dimension(600,600));
        transformSelect = new JComboBox<String>();
        transformSelect.addItem("None");
        for (int i = 1; i < 10; i++) {
            transformSelect.addItem("No. " + i);
        }
        transformSelect.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.repaint();
            }
        });
        setLayout(new BorderLayout(3,3));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        top.add(new JLabel("Transform: "));
        top.add(transformSelect);
        add(display,BorderLayout.CENTER);
        add(top,BorderLayout.NORTH);
    }

}
