package world.organizmy;
import world.Organizm;
import world.Swiat;
import world.TypSwiata;
import java.util.Random;

public abstract class Zwierze extends Organizm {

    public void akcja(){
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY){
            int dx=0,  dy=0;
            Random rand = new Random();
            do{
                dx=0;
                dy=0;
                int pom=rand.nextInt(4);
                if(pom==0) dx=1;
                else if(pom==1) dx=-1;
                else if(pom==2) dy=1;
                 else if(pom==3) dy=-1;
            }while(!mozeIsc(dx,dy));

            swiat.dodajKomunikat(nazwa+" rusza się z ("+x+","+y+") na ("+(x+dx)+","+(y+dy)+")");
            idz(x+dx, y+dy);

        }
        else{
            int dx=0,  dy=0;
            Random rand = new Random();
            do{
                dx=0;
                dy=0;
                int pom=rand.nextInt(6);
                //L
                if(pom==0){
                   dx=-1;
                }
                //LU
                else if(pom==1){
                    if(y%2==0) {dy=-1; dx=-1;}
                    else{dy=-1; dx=0;}
                }
                //RU
                else if(pom==2) {
                    if(y%2==0) {dy=-1; dx=0;}
                    else{dy=-1; dx=1;}
                }
                //R
                else if(pom==3){
                    dx=1;
                }
                //RD
                else if(pom==4) {
                    if(y%2==0) {dy=1; dx=0;}
                    else{dy=1; dx=1;}
                }
                //LD
                else if(pom==5){
                    if(y%2==0) {dy=1; dx=-1;}
                    else{dy=1; dx=0;}
                }
            }while(!mozeIsc(dx,dy));

            swiat.dodajKomunikat(nazwa+" rusza się z ("+x+","+y+") na ("+(x+dx)+","+(y+dy)+")");
            idz(x+dx, y+dy);
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
    public void idz(int dx,int dy){
    px=x;
    py=y;

            if(swiat.czyPuste(dx, dy)) {
                x = dx;
                y = dy;
                swiat.zwolnijPole(px, py);
                swiat.ustawPole(this);
            }
            else kolizja(this, swiat.zwrocOrganizm(dx,dy));

    }
    public void kolizja(Organizm atakujacy, Organizm obronca){
        swiat.dodajKomunikat("Kolizja na ("+obronca.zwrocX()+","+obronca.zwrocY()+")");
        if(obronca.zwrocZnak()==atakujacy.zwrocZnak())
            rozmnoz(atakujacy,obronca);
        else walcz(atakujacy,obronca);
    }
    public void walcz(Organizm atakujacy, Organizm obronca){
        swiat.dodajKomunikat(nazwa+" atakuje "+obronca.zwrocNazwe()+" na ("+(obronca.zwrocX())+","+(obronca.zwrocY())+")");

        if(!(atakujacy.czyNiesmiertelny()&&obronca.zwrocSile()>atakujacy.zwrocSile()) &&
                !(obronca.czyNiesmiertelny()&&atakujacy.zwrocSile()>=obronca.zwrocSile())) {
            if (obronca.umiejetnosc(atakujacy, obronca) == false) {
                if (obronca.zwrocSile() <= atakujacy.zwrocSile()) {
                    swiat.dodajKomunikat("Atakujacy wygrywa!");
                    int dx = obronca.zwrocX();
                    int dy = obronca.zwrocY();
                    obronca.ustawStan(StanOrganizmu.DEAD);
                    swiat.zwolnijPole(dx, dy);
                    idz(dx, dy);
                    swiat.zmniejszLicznik();
                } else {
                    swiat.dodajKomunikat("Atakujacy przegrywa!");
                    atakujacy.ustawStan(StanOrganizmu.DEAD);
                    swiat.zwolnijPole(atakujacy.zwrocX(), atakujacy.zwrocY());
                    swiat.zmniejszLicznik();
                }
            }
            if (czyNiesmiertelny()) {
                ustawStan(StanOrganizmu.ALIVE);
            }
        }
    }
    public void rozmnoz(Organizm atakujacy, Organizm obronca){
        int dx=0, dy=0;
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY) {
            boolean fu =false, fd=false, fl=false, fr=false, f;
            Random rand=new Random();
            do{
                int pom=rand.nextInt(6);
                dx=0;
                dy=0;
                if(pom==0) {dx=1; fr=true;}
                else if(pom==1) {dx=-1; fl=true;}
                else if(pom==2) {dy=1; fu=true;}
                else if(pom==3) {dy=-1; fd=true;}
                f = fr && fl && fu && fd;

                if(obronca.mozeRozmnozyc(dx,dy)) break;
            }while(!f);

            if(f || obronca.zwrocStan()==StanOrganizmu.BORN){
                swiat.dodajKomunikat("Nie mozna rozmnozyc od "+nazwa+" na ("+obronca.zwrocX()+","+obronca.zwrocY()+")");
            }
            else if(obronca.mozeRozmnozyc(dx,dy)){
                dodaj(obronca.zwrocX()+dx, obronca.zwrocY()+dy);
                swiat.dodajKomunikat("Nowy organizm typu "+nazwa+" na ("+(obronca.zwrocX()+dx)+","+(obronca.zwrocY()+dy)+")");
            }
        }
        else{
            boolean flu =false, fru=false, fl=false, fr=false, fld=false, frd=false, f;
            Random rand=new Random();
            do{
                    dx=0;
                    dy=0;
                    int pom=rand.nextInt(6);
                    //L
                    if(pom==0){
                        dx=-1;
                        fl=true;
                    }
                    //LU
                    else if(pom==1){
                        if(y%2==0) {dy=-1; dx=-1;}
                        else{dy=-1; dx=0;}
                        flu=true;
                    }
                    //RU
                    else if(pom==2) {
                        if(y%2==0) {dy=-1; dx=0;}
                        else{dy=-1; dx=1;}
                        fru=true;
                    }
                    //R
                    else if(pom==3){
                        dx=1;
                        fr=true;
                    }
                    //RD
                    else if(pom==4) {
                        if(y%2==0) {dy=1; dx=0;}
                        else{dy=1; dx=1;}
                        frd=true;
                    }
                    //LD
                    else if(pom==5){
                        if(y%2==0) {dy=1; dx=-1;}
                        else{dy=1; dx=0;}
                        fld=true;
                    }
                f = fl && flu && fld && fr && frd && fru;

                if(obronca.mozeRozmnozyc(dx,dy)) break;
            }while(!f);

            if(f || obronca.zwrocStan()==StanOrganizmu.BORN){
                swiat.dodajKomunikat("Nie mozna rozmnozyc od "+nazwa+" na ("+obronca.zwrocX()+","+obronca.zwrocY()+")");
            }
            else if(obronca.mozeRozmnozyc(dx,dy)){
                dodaj(obronca.zwrocX()+dx, obronca.zwrocY()+dy);
                swiat.dodajKomunikat("Nowy organizm typu "+nazwa+" na ("+(obronca.zwrocX()+dx)+","+(obronca.zwrocY()+dy)+")");
            }
        }
    }
    abstract public void dodaj(int x, int y);

    public Zwierze(int x, int y, Swiat swiat){
        super(x,y,swiat);
    }



}
