package world.organizmy;
import world.Swiat;
import world.Organizm;
import java.util.Random;
import world.TypSwiata;

public class Lis extends Zwierze {
    public Lis(int x, int y, Swiat s){
        super(x,y,s);
        sila=3;
        inicjatywa=7;
        znak='l';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Lis";
    }
    @Override
    public void akcja(){
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY) {
            int dx = 0, dy = 0;
            boolean fu = false, fd = false, fl = false, fr = false, f;
            Random rand = new Random();

            do {
                int pom = rand.nextInt(4);
                dx = 0;
                dy = 0;
                if (pom == 0) {
                    dx = 1;
                    fr = true;
                } else if (pom == 1) {
                    dx = -1;
                    fl = true;
                } else if (pom == 2) {
                    dy = 1;
                    fd = true;
                } else if (pom == 3) {
                    dy = -1;
                    fu = true;
                }
                f = fr && fl && fu && fd;

                if (mozeIsc(dx, dy)) {
                    if (!swiat.czyPuste(x + dx, y + dy)) {
                        if (swiat.zwrocOrganizm(x + dx, y + dy).zwrocSile() <= sila) {
                            break;
                        } else continue;
                    } else break;
                }


            } while (!f);

            if (f) {
                dx = 0;
                dy = 0;
            }

            swiat.dodajKomunikat(nazwa + " rusza się z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");

            if (dx != 0 || dy != 0)
                idz(x + dx, y + dy);
        }
        else{
            boolean flu =false, fru=false, fl=false, fr=false, fld=false, frd=false, f;
            Random rand=new Random();
            int dx, dy;
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

                if (mozeIsc(dx, dy)) {
                    if (!swiat.czyPuste(x + dx, y + dy)) {
                        if (swiat.zwrocOrganizm(x + dx, y + dy).zwrocSile() <= sila) {
                            break;
                        } else continue;
                    } else break;
                }
            }while(!f);

            if (f) {
                dx = 0;
                dy = 0;
            }

            swiat.dodajKomunikat(nazwa + " rusza się z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");

            if (dx != 0 || dy != 0)
                idz(x + dx, y + dy);
        }
    }

    public void dodaj(int x, int y){
        Organizm o=new Lis(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
}
