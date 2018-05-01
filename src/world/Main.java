package world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {
        Swiat swiat=new Swiat(5,5, TypSwiata.ZWYKLY);
        Okno okno=new Okno(swiat);
        swiat.ustawOkno(okno);
    }
}
