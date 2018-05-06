package world.organizmy;
import world.Swiat;
import world.Organizm;
import world.TypSwiata;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Random;

public class Czlowiek extends Zwierze{
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
        swiat.turaCzlowieka();
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
