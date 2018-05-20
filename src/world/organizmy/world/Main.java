package world;
import world.organizmy.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {

        Swiat swiat=new SwiatZwykly(20,20);
        swiat.dodajOrganizm(new Czlowiek(5,5,swiat));
        swiat.generator(2);



        Okno okno=new Okno(swiat);
        swiat.ustawOkno(okno);
        swiat.wykonajTure();
    }
}
