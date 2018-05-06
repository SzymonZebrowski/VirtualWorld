package world.organizmy;
import world.Swiat;
import world.Organizm;

public class Mlecz extends Roslina {
    public Mlecz (int x, int y, Swiat s){
        super(x,y,s);
        sila=0;
        inicjatywa=0;
        znak='M';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Mlecz";
        prawdopodobienstwo=10;
    }

    public void akcja()
    {
        for(int i=0; i<3; i++)
            super.akcja();
    }

    public void dodaj(int x, int y){
        Organizm o=new Mlecz(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
    }
