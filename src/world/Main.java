package world;
import world.organizmy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {

        Swiat swiat=new Swiat(40,20, TypSwiata.HEX);
        swiat.dodajOrganizm(new Czlowiek(5,5,swiat));
        swiat.generator(2);



        Okno okno=new Okno(swiat);
        swiat.ustawOkno(okno);
        swiat.wykonajTure();
    }
}
