package world.organizmy;
import world.Swiat;
import world.Organizm;

public class Guarana extends Roslina {
    public Guarana(int x, int y, Swiat s){
        super(x,y,s);
        sila=0;
        inicjatywa=0;
        znak='G';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Guarana";
        prawdopodobienstwo=10;
    }

    public void dodaj(int x, int y){
        Organizm o=new Guarana(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }

    @Override
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca) {
        atakujacy.ustawSile(atakujacy.zwrocSile()+3);
        return false;
    }
}
