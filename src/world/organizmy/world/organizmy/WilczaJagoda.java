package world.organizmy;
import world.Swiat;
import world.Organizm;

public class WilczaJagoda extends Roslina {
    public WilczaJagoda(int x, int y, Swiat s){
        super(x,y,s);
        sila=99;
        inicjatywa=0;
        znak='W';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Wilcza Jagoda";
        prawdopodobienstwo=10;
    }

    public void dodaj(int x, int y){
        Organizm o=new WilczaJagoda(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }

    @Override
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca) {
        if(atakujacy.czyNiesmiertelny()==false){
            atakujacy.ustawStan(StanOrganizmu.DEAD);
            atakujacy.ustawSile(0);
        }
        return false;
    }
}
