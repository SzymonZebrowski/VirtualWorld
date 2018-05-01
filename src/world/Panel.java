package world;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    Swiat swiat;

    public Panel(Swiat swiat) {
        setPreferredSize(new Dimension(swiat.zwrocSzerokosc() * 20 + 20, swiat.zwrocWysokosc() * 20 + 120));
        this.swiat = swiat;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //g2d.drawRect(100,100,100,100);
        for (int i = 0; i < swiat.zwrocWysokosc(); i++) {
            for (int j = 0; j < swiat.zwrocSzerokosc(); j++) {
                if (swiat.typSwiata == TypSwiata.HEX) {
                    if ((i + j) % 2 == 0) {
                        // g2d.setPaint(new Color(0,70,160));
                        // g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        if (i % 2 == 0) g2d.drawRect(10 + j * 20, 50 + i * 20, 20, 20);
                        else g2d.drawRect(20 + j * 20, 50 + i * 20, 20, 20);
                    } else {
                        //g2d.setPaint(new Color(150,150,150));
                        if (j % 2 == 1) g2d.drawRect(10 + j * 20, 50 + i * 20, 20, 20);
                        else g2d.drawRect(20 + j * 20, 50 + i * 20, 20, 20);
                    }
                } else {
                    if ((i + j) % 2 == 0) {
                        // g2d.setPaint(new Color(0,70,160));
                        // g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        g2d.drawRect(10 + j * 20, 50 + i * 20, 20, 20);
                    } else {
                        //g2d.setPaint(new Color(150,150,150));
                        g2d.drawRect(10 + j * 20, 50 + i * 20, 20, 20);
                    }
                }
            }

        }

    }
}
