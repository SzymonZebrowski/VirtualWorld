package world;
import world.organizmy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {
        Swiat swiat=new Swiat(8,8, TypSwiata.ZWYKLY);
        swiat.dodajOrganizm(new Owca(0,0,swiat));
        swiat.dodajOrganizm(new Owca(7,7,swiat));

        Okno okno=new Okno(swiat);
        swiat.ustawOkno(okno);
        swiat.symuluj();
    }
}
