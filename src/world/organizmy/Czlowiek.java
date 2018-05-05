package world.organizmy;
import world.Swiat;
import world.Organizm;
import world.TypSwiata;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Random;

public class Czlowiek extends Zwierze implements KeyListener {
    public Czlowiek(int x, int y, Swiat s){
        super(x,y,s);
        sila=5;
        inicjatywa=4;
        znak='@';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Człowiek";
    }

    @Override
    public void akcja(){

    }


    @Override
    public void keyTyped(KeyEvent k){}
    @Override
    public void keyReleased(KeyEvent k){}
    @Override
    public void keyPressed(KeyEvent k){
        int key=k.getKeyCode();
        if(key==KeyEvent.VK_UP) System.out.println("UP");
        if(key==KeyEvent.VK_DOWN) System.out.println("DOWN");
        if(key==KeyEvent.VK_LEFT) System.out.println("LEFT");
        if(key==KeyEvent.VK_RIGHT) System.out.println("RIGHT");
    }

    @Override
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca) {
     return false;
    }

    public void dodaj(int x, int y){
        Organizm o=new Czlowiek(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }

}
