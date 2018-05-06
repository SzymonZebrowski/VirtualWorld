package world;
import world.organizmy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {
        Swiat swiat=new Swiat(30,30, TypSwiata.ZWYKLY);
        //swiat.generator(1);
        swiat.dodajOrganizm(new Czlowiek(5,5,swiat));
        Okno okno=new Okno(swiat);
        swiat.ustawOkno(okno);
    }
}
