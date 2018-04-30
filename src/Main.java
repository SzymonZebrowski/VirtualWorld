import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{

    public static void main(String[] args) {
        Swiat swiat=new Swiat(20,20, TypSwiata.ZWYKLY);
        Okno okno=new Okno(swiat);
    }
}
