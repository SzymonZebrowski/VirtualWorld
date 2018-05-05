package world.organizmy;
import world.Swiat;
import world.Organizm;
import world.TypSwiata;

import java.util.Random;

public class Zolw extends Zwierze {
    public Zolw(int x, int y, Swiat s){
        super(x,y,s);
        sila=2;
        inicjatywa=1;
        znak='z';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Żółw";
    }

    @Override
    public void akcja(){
        Random rand=new Random();
        int pom=rand.nextInt(4);
        if(pom==0){
            super.akcja();
        }
    }

    @Override
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca) {
       if(atakujacy.zwrocSile()<5){swiat.dodajKomunikat(obronca.zwrocNazwe()+" odpiera atak "+atakujacy.zwrocNazwe()); return true;}
       else return false;
    }

    public void dodaj(int x, int y){
        Organizm o=new Zolw(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
}
