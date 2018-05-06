package world.organizmy;
import world.Organizm;
import world.Swiat;
import world.TypSwiata;
import java.util.Random;

public abstract class Roslina extends Organizm {
    public void akcja(){
        Random rand = new Random();
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY){
            int p=rand.nextInt(100);
            if(p<prawdopodobienstwo) {
                int dx = 0, dy = 0;
                boolean fu=false, fd = false, fl = false, fr = false, f;
                do {
                    int pom=rand.nextInt(4);
                    dx = 0;
                    dy = 0;
                    if (pom == 0){dx = 1; fr=true;}
                    else if (pom == 1){dx = -1; fl=true;}
                    else if (pom == 2){dy = -1; fu=true;}
                    else if (pom == 3){dy = 1; fd=true;}
                    f = fr && fl && fu && fd;

                    if(mozeRozmnozyc(dx,dy)) break;
                } while (!f);

                swiat.dodajKomunikat("Próba rozmnozenia od " + nazwa +" z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");
                System.out.println("Próba rozmnozenia od " + nazwa +" z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");

                if(f) System.out.println("Nie mozna rozmnozyć! Brak miejsca!");
                else if(mozeRozmnozyc(dx,dy)){
                    dodaj(x+dx, y+dy);
                    swiat.dodajKomunikat("Nowy organizm typu "+nazwa+" na ("+(x+dx)+","+(y+dy)+")");
                   System.out.println("Nowy organizm typu "+nazwa+" na ("+(x+dx)+","+(y+dy)+")");
                }
            }
        }
        else{
            //hex
        }
    }
    public boolean mozeIsc(int dx, int dy){
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY){
            if(x+dx>=0 && x+dx<swiat.zwrocSzerokosc() && y+dy>=0 && y+dy<swiat.zwrocWysokosc()) return true;
            else return false;
        }
        else{
            //hex
            return false;
        }
    }
    public boolean mozeRozmnozyc(int dx, int dy){
        if(mozeIsc(dx,dy)){
            if(swiat.czyPuste(x+dx, y+dy)){
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void idz(int dx,int dy){}
    public void kolizja(Organizm atakujacy, Organizm obronca){}
    public void walcz(Organizm atakujacy, Organizm obronca){}
    public void rozmnoz(Organizm atakujacy, Organizm obronca){}
    abstract public void dodaj(int x, int y);

    public Roslina(int x, int y, Swiat swiat){
        super(x,y,swiat);
    }

    int prawdopodobienstwo;


}
