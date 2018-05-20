package world.organizmy;
import world.Swiat;
import world.Organizm;

public class Trawa extends Roslina {
    public Trawa(int x, int y, Swiat s){
        super(x,y,s);
        sila=0;
        inicjatywa=0;
        znak='T';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Trawa";
        prawdopodobienstwo=10;
    }

    public void dodaj(int x, int y){
        Organizm o=new Trawa(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
}
