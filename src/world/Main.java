package world;
import world.organizmy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {
        Swiat swiat=new Swiat(10,10, TypSwiata.ZWYKLY);
        swiat.dodajOrganizm(new Czlowiek(5,5,swiat));
        swiat.generator(1);

        Okno okno=new Okno(swiat);
        swiat.ustawOkno(okno);
    }
}
