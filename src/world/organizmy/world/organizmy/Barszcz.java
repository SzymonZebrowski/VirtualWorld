package world.organizmy;
import world.Swiat;
import world.Organizm;
import world.TypSwiata;

public class Barszcz extends Roslina {
    public Barszcz(int x, int y, Swiat s){
        super(x,y,s);
        sila=10;
        inicjatywa=0;
        znak='B';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Barszcz";
        prawdopodobienstwo=10;
    }

    public void dodaj(int x, int y){
        Organizm o=new Barszcz(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);
    }

    @Override
    public void akcja(){
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY) {
            if (mozeIsc(-1, 0) && !swiat.czyPuste(x-1,y)){
                char pom=swiat.zwrocOrganizm(x-1,y).zwrocZnak();
                if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x-1,y).czyNiesmiertelny())
                    swiat.zwrocOrganizm(x-1,y).ustawStan(StanOrganizmu.DEAD);
            }
            if (mozeIsc(1, 0) && !swiat.czyPuste(x+1,y)){
                char pom=swiat.zwrocOrganizm(x+1,y).zwrocZnak();
                if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x+1,y).czyNiesmiertelny())
                    swiat.zwrocOrganizm(x+1,y).ustawStan(StanOrganizmu.DEAD);
            }
           if (mozeIsc(0, -1) && !swiat.czyPuste(x,y-1)){
                char pom=swiat.zwrocOrganizm(x,y-1).zwrocZnak();
                if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x,y-1).czyNiesmiertelny())
                    swiat.zwrocOrganizm(x,y-1).ustawStan(StanOrganizmu.DEAD);
            }
            if (mozeIsc(0, 1) && !swiat.czyPuste(x,y+1)){
                char pom=swiat.zwrocOrganizm(x,y+1).zwrocZnak();
                if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x,y+1).czyNiesmiertelny())
                    swiat.zwrocOrganizm(x,y+1).ustawStan(StanOrganizmu.DEAD);
            }

            super.akcja();
        }
        else{
            if(y%2==0){
                //LU
                if (mozeIsc(-1, -1) && !swiat.czyPuste(x-1,y-1)){
                    char pom=swiat.zwrocOrganizm(x-1,y-1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x-1,y-1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x-1,y-1).ustawStan(StanOrganizmu.DEAD);
                }
                //LD
                if (mozeIsc(-1, 1) && !swiat.czyPuste(x-1,y+1)){
                    char pom=swiat.zwrocOrganizm(x-1,y+1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x-1,y+1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x-1,y+1).ustawStan(StanOrganizmu.DEAD);
                }
                //RD
                if (mozeIsc(0, 1) && !swiat.czyPuste(x,y+1)){
                    char pom=swiat.zwrocOrganizm(x,y+1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x,y+1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x,y+1).ustawStan(StanOrganizmu.DEAD);
                }
                //RU
                if (mozeIsc(0, -1) && !swiat.czyPuste(x,y-1)){
                    char pom=swiat.zwrocOrganizm(x,y-1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x,y-1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x,y-1).ustawStan(StanOrganizmu.DEAD);
                }
            }
            else{
                //LU
                if (mozeIsc(0, -1) && !swiat.czyPuste(x,y-1)){
                    char pom=swiat.zwrocOrganizm(x,y-1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x,y-1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x,y-1).ustawStan(StanOrganizmu.DEAD);
                }
                //LD
                if (mozeIsc(0, 1) && !swiat.czyPuste(x,y+1)){
                    char pom=swiat.zwrocOrganizm(x,y+1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x,y+1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x,y+1).ustawStan(StanOrganizmu.DEAD);
                }
                //RD
                if (mozeIsc(1, 1) && !swiat.czyPuste(x+1,y+1)){
                    char pom=swiat.zwrocOrganizm(x+1,y+1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x+1,y+1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x+1,y+1).ustawStan(StanOrganizmu.DEAD);
                }
                //RU
                if (mozeIsc(1, -1) && !swiat.czyPuste(x+1,y-1)){
                    char pom=swiat.zwrocOrganizm(x+1,y-1).zwrocZnak();
                    if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x+1,y-1).czyNiesmiertelny())
                        swiat.zwrocOrganizm(x+1,y-1).ustawStan(StanOrganizmu.DEAD);
                }
            }
            //L
            if (mozeIsc(-1, 0) && !swiat.czyPuste(x-1,y)){
                char pom=swiat.zwrocOrganizm(x-1,y).zwrocZnak();
                if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x-1,y).czyNiesmiertelny())
                    swiat.zwrocOrganizm(x-1,y).ustawStan(StanOrganizmu.DEAD);
            }
            //R
            if (mozeIsc(1, 0) && !swiat.czyPuste(x+1,y)){
                char pom=swiat.zwrocOrganizm(x+1,y).zwrocZnak();
                if(pom!='B' && pom!='G' && pom!='W' && pom!='T' && pom!='M' && !swiat.zwrocOrganizm(x+1,y).czyNiesmiertelny())
                    swiat.zwrocOrganizm(x+1,y).ustawStan(StanOrganizmu.DEAD);
            }
            super.akcja();
        }
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
