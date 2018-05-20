package world;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TuraGraczaOkno extends JFrame implements KeyListener {
    TuraGraczaOkno(){
        super("Symulacja Swiata- Szymon Żebrowski 172165");
        pack();
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent k){}
    @Override
    public void keyReleased(KeyEvent k){}
    @Override
    public void keyPressed(KeyEvent k){}
}
