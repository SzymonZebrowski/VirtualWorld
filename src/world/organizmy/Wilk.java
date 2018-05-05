package world.organizmy;
import world.Swiat;
import world.Organizm;

public class Wilk extends Zwierze {
    public Wilk(int x, int y, Swiat s){
        super(x,y,s);
        sila=9;
        inicjatywa=5;
        znak='w';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Wilk";
    }

    public void dodaj(int x, int y){
        Organizm o=new Wilk(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
}
