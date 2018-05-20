package world.organizmy;
import world.Swiat;
import world.Organizm;
public class Owca extends Zwierze {
    public Owca(int x, int y, Swiat s){
        super(x,y,s);
        sila=4;
        inicjatywa=4;
        znak='o';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Owca";
    }

    public void dodaj(int x, int y){
        Organizm o=new Owca(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
}
