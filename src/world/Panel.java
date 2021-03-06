package world;

import javax.swing.*;
import java.awt.*;
import java.lang.Math;

public class Panel extends JPanel {
    Swiat swiat;
    Polygon[][] polaHex;
    double hexWidth;
    int hexHeight;
    int hexRadius;

    public Panel(Swiat swiat) {
        setPreferredSize(new Dimension(swiat.zwrocSzerokosc() * 20 + 20, swiat.zwrocWysokosc() * 20 + 170));
        this.swiat = swiat;
        polaHex=new Polygon[swiat.zwrocWysokosc()][swiat.zwrocSzerokosc()];
        hexRadius=10;
        hexHeight=2*hexRadius;
        //hexWidth=(10 * Math.sqrt(3));
        //hexWidth=2*hexRadius;
        hexWidth=(hexRadius-1)*2;
    }

    public void malujHex(Graphics2D g2d, Polygon hex, int i, int j){
        if(swiat.zwrocOrganizm(j,i)!=null) {
            char pom = swiat.zwrocOrganizm(j, i).zwrocZnak();
            if (pom == 'o') {
                g2d.setPaint(new Color(196, 195, 205));
                g2d.fillPolygon(hex);
            } else if (pom == 'w') {
                g2d.setPaint(new Color(109, 111, 112));
                g2d.fillPolygon(hex);            }
            else if (pom == 'l') {
                g2d.setPaint(new Color(238, 96, 1));
                g2d.fillPolygon(hex);
            }  else if (pom == 'z') {
                g2d.setPaint(new Color(94, 47, 0));
                g2d.fillPolygon(hex);
            } else if (pom == 'a') {
                g2d.setPaint(new Color(191, 131, 27));
                g2d.fillPolygon(hex);
            } else if (pom == '@') {
                g2d.setPaint(new Color(3, 3, 3));
                g2d.fillPolygon(hex);
            } else if (pom == 'T') {
                g2d.setPaint(new Color(52, 174, 8));
                g2d.fillPolygon(hex);
            } else if (pom == 'G') {
                g2d.setPaint(new Color(174, 40, 32));
                g2d.fillPolygon(hex);
            } else if (pom == 'W') {
                g2d.setPaint(new Color(75, 23, 120));
                g2d.fillPolygon(hex);
            } else if (pom == 'B') {
                g2d.setPaint(new Color(0, 173, 174));
                g2d.fillPolygon(hex);
            } else if (pom == 'M') {
                g2d.setPaint(new Color(236, 217, 6));
                g2d.fillPolygon(hex);
            }
        }
        else {
            //g2d.setPaint(new Color(150,150,150));
            g2d.setPaint(new Color(0,0,0));
            g2d.drawPolygon(hex);
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //g2d.drawRect(100,100,100,100);
        for (int i = 0; i < swiat.zwrocWysokosc(); i++) {
            for (int j = 0; j < swiat.zwrocSzerokosc(); j++) {
                if (swiat.typSwiata == TypSwiata.HEX) {

                    if(i%2==0) {
                        double xpoints[] = {10+j * hexWidth,10+j * hexWidth + hexWidth/2,
                                10+j*hexWidth + hexWidth, 10+j * hexWidth + hexWidth,
                                10+j * hexWidth + hexWidth/2, 10+ j * hexWidth};
                        double ypoints[] = {50+i * 15 + 5, 50+i * 15, 50+i * 15 + 5, 50+i * 15 + 15, 50+i * 15 + 20, 50+i * 15 + 15};
                        int xpo[] = {0, 0, 0, 0, 0, 0};
                        int ypo[] = {0, 0, 0, 0, 0, 0};
                        for (int ii = 0; ii < 6; ii++) {
                            xpo[ii] = (int) xpoints[ii];
                            ypo[ii] = (int) ypoints[ii];
                        }
                        polaHex[i][j] = new Polygon(xpo, ypo, 6);
                        malujHex(g2d,polaHex[i][j],i,j);
                    }
                    else{
                        double xpoints[] = {10+j * hexWidth + hexWidth/2,10+j * hexWidth + hexWidth,
                                10+j*hexWidth + hexWidth + hexWidth/2, 10+j * hexWidth + hexWidth+ hexWidth/2,
                                10+j * hexWidth + hexWidth, 10+ j * hexWidth + hexWidth/2};
                        double ypoints[] = {50+i * 15 + 5, 50+i * 15, 50+i * 15 + 5, 50+i * 15 + 15, 50+i * 15 + 20, 50+i * 15 + 15};
                        int xpo[] = {0, 0, 0, 0, 0, 0};
                        int ypo[] = {0, 0, 0, 0, 0, 0};
                        for (int ii = 0; ii < 6; ii++) {
                            xpo[ii] = (int) xpoints[ii];
                            ypo[ii] = (int) ypoints[ii];
                        }
                        Polygon hex = new Polygon(xpo, ypo, 6);
                        malujHex(g2d,hex,i,j);
                    }

/*
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
*/

                } else { //swiat zwykly
                    if(swiat.zwrocOrganizm(j,i)!=null) {
                        char pom = swiat.zwrocOrganizm(j, i).zwrocZnak();
                        if (pom == 'o') {
                            g2d.setPaint(new Color(196, 195, 205));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'w') {
                            g2d.setPaint(new Color(109, 111, 112));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        }
                        else if (pom == 'l') {
                            g2d.setPaint(new Color(238, 96, 1));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        }  else if (pom == 'z') {
                            g2d.setPaint(new Color(94, 47, 0));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'a') {
                            g2d.setPaint(new Color(191, 131, 27));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == '@') {
                            g2d.setPaint(new Color(3, 3, 3));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'T') {
                            g2d.setPaint(new Color(52, 174, 8));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'G') {
                            g2d.setPaint(new Color(174, 40, 32));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'W') {
                            g2d.setPaint(new Color(75, 23, 120));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'B') {
                            g2d.setPaint(new Color(0, 173, 174));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        } else if (pom == 'M') {
                            g2d.setPaint(new Color(236, 217, 6));
                            g2d.fillRect(10 + j * 20, 50 + i * 20, 20, 20);
                        }
                    }
                     else {
                        //g2d.setPaint(new Color(150,150,150));
                        g2d.setPaint(new Color(0,0,0));
                        g2d.drawRect(10 + j * 20, 50 + i * 20, 20, 20);
                    }
                }
            }

        }

    }
}
