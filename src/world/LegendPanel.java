package world;

import javax.swing.*;
import java.awt.*;

public class LegendPanel extends JPanel {
    public LegendPanel() {
        setPreferredSize(new Dimension(200, 250));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
                            g2d.setPaint(new Color(196, 195, 205));
                            g2d.fillRect(10,10,20, 20);
                            g2d.setPaint(new Color(109, 111, 112));
                            g2d.fillRect(10,30,20, 20);
                            g2d.setPaint(new Color(238, 96, 1));
                            g2d.fillRect(10,50,20, 20);
                            g2d.setPaint(new Color(94, 47, 0));
                            g2d.fillRect(10,70,  20, 20);
                            g2d.setPaint(new Color(191, 131, 27));
                            g2d.fillRect(10,90, 20, 20);
                            g2d.setPaint(new Color(3, 3, 3));
                            g2d.fillRect(10,110,20, 20);
                            g2d.setPaint(new Color(52, 174, 8));
                            g2d.fillRect(10,130, 20, 20);
                            g2d.setPaint(new Color(174, 40, 32));
                            g2d.fillRect(10,150, 20, 20);
                            g2d.setPaint(new Color(75, 23, 120));
                            g2d.fillRect(10,170, 20,  20);
                            g2d.setPaint(new Color(0, 173, 174));
                            g2d.fillRect(10,190, 20,  20);
                            g2d.setPaint(new Color(236, 217, 6));
                            g2d.fillRect(10,210,20,  20);




    }
}
