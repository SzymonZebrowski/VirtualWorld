package world.organizmy;
import world.Organizm;
import world.Swiat;
import world.TypSwiata;
import java.util.Random;

public abstract class Roslina extends Organizm {
    public void akcja(){
        Random rand = new Random();
        int p=rand.nextInt(100);
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY){
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

                if(f) swiat.dodajKomunikat("Nie mozna rozmnozyć! Brak miejsca!");
                else if(mozeRozmnozyc(dx,dy)){
                    dodaj(x+dx, y+dy);
                    swiat.dodajKomunikat("Nowy organizm typu "+nazwa+" na ("+(x+dx)+","+(y+dy)+")");
                }
            }
        }
        else{
            if(p<prawdopodobienstwo) {
                int dx = 0, dy = 0;
                boolean flu =false, fru=false, fl=false, fr=false, fld=false, frd=false, f;
                do {
                    dx = 0;
                    dy = 0;
                    int pom = rand.nextInt(6);
                    //L
                    if (pom == 0) {
                        dx = -1;
                        fl = true;
                    }
                    //LU
                    else if (pom == 1) {
                        if (y % 2 == 0) {
                            dy = -1;
                            dx = -1;
                        } else {
                            dy = -1;
                            dx = 0;
                        }
                        flu = true;
                    }
                    //RU
                    else if (pom == 2) {
                        if (y % 2 == 0) {
                            dy = -1;
                            dx = 0;
                        } else {
                            dy = -1;
                            dx = 1;
                        }
                        fru = true;
                    }
                    //R
                    else if (pom == 3) {
                        dx = 1;
                        fr = true;
                    }
                    //RD
                    else if (pom == 4) {
                        if (y % 2 == 0) {
                            dy = 1;
                            dx = 0;
                        } else {
                            dy = 1;
                            dx = 1;
                        }
                        frd = true;
                    }
                    //LD
                    else if (pom == 5) {
                        if (y % 2 == 0) {
                            dy = 1;
                            dx = -1;
                        } else {
                            dy = 1;
                            dx = 0;
                        }
                        fld = true;
                    }
                    f = fl && flu && fld && fr && frd && fru;
                    if (mozeRozmnozyc(dx, dy)) break;
                }while(!f);

                swiat.dodajKomunikat("Próba rozmnozenia od " + nazwa +" z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");

                if(f)swiat.dodajKomunikat("Nie mozna rozmnozyć! Brak miejsca!");
                else if(mozeRozmnozyc(dx,dy)){
                    dodaj(x+dx, y+dy);
                    swiat.dodajKomunikat("Nowy organizm typu "+nazwa+" na ("+(x+dx)+","+(y+dy)+")");
                }
            }
        }
    }
    public boolean mozeIsc(int dx, int dy){
            if(x+dx>=0 && x+dx<swiat.zwrocSzerokosc() && y+dy>=0 && y+dy<swiat.zwrocWysokosc()) return true;
            else return false;
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
