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
        trwanie=0;
        czekanie=0;
        stan=StanOrganizmu.BORN;
        nazwa="Człowiek";
    }

    @Override
    public void akcja(){
        niesmiertelnosc=swiat.zwrocUmiejetnosc();
        trwanie=swiat.zwrocTrwanie();
        czekanie=swiat.zwrocPozostalo();
        int dx=0, dy=0;
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY) {
            if (swiat.zwrocKierunekGracza() != null) {
                String dir = swiat.zwrocKierunekGracza();
                switch (dir) {
                    case "UP":
                        dy--;
                        break;
                    case "DOWN":
                        dy++;
                        break;
                    case "LEFT":
                        dx--;
                        break;
                    case "RIGHT":
                        dx++;
                        break;
                }
                if (dx != 0 || dy != 0) {
                    if (mozeIsc(dx, dy))
                        idz(x + dx, y + dy);
                }
            }
        }else {
            if (swiat.zwrocKierunekGracza() != null) {
                String dir = swiat.zwrocKierunekGracza();
                switch (dir) {
                    case "L":
                        dx = -1;
                        break;
                    case "LD":
                        if (y % 2 == 0) {
                            dy = 1;
                            dx = -1;
                        } else {
                            dy = 1;
                        }
                        break;
                    case "LU":
                        if (y % 2 == 0) {
                            dy = -1;
                            dx = -1;
                        } else {
                            dy = -1;
                        }
                        break;
                    case "R":
                        dx = 1;
                        break;
                    case "RD":
                        if (y % 2 == 0) {
                            dy = 1;
                        } else {
                            dy = 1;
                            dx = 1;
                        }
                        break;
                    case "RU":
                        if (y % 2 == 0) {
                            dy = -1;
                        } else {
                            dy = -1;
                            dx = 1;
                        }
                        break;
                }
                if (dx != 0 || dy != 0) {
                    if (mozeIsc(dx, dy))
                        idz(x + dx, y + dy);
                }
            }
        }
    }

    @Override
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca) {
        if(niesmiertelnosc && atakujacy.zwrocSile()>sila){
            return true;
        }
     return false;
    }

    public void dodaj(int x, int y){
        Organizm o=new Czlowiek(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }

    public String zapiszDoPliku(){
    String str;
    int s=0;
    if(stan==StanOrganizmu.BORN) s=0;
    else if(stan==StanOrganizmu.ALIVE) s=1;
    str=znak+" "+sila+" "+x+" "+y+" "+s+" "+niesmiertelnosc+" "+trwanie+" "+czekanie;

    return str;
    }

    int trwanie;
    int czekanie;

}
