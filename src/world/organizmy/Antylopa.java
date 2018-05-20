package world.organizmy;
import world.Swiat;
import world.Organizm;
import java.util.Random;
import world.TypSwiata;

public class Antylopa extends Zwierze {
    public Antylopa(int x, int y, Swiat s){
        super(x,y,s);
        sila=4;
        inicjatywa=4;
        znak='a';
        wiek=0;
        stan=StanOrganizmu.BORN;
        nazwa="Antylopa";
    }
    @Override
    public void akcja(){
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY){

           Random rand = new Random();
           int dx=0, dy=0;
           do {
               do {
                   dx=0;
                   dy=0;
                   int pom = rand.nextInt(4);
                   if (pom == 0) dx++;
                   else if (pom == 1) dx--;
                   else if (pom == 2) dy++;
                   else if (pom == 3) dy--;

                   pom = rand.nextInt(4);
                   if (pom == 0) dx++;
                   else if (pom == 1) dx--;
                   else if (pom == 2) dy++;
                   else if (pom == 3) dy--;
               } while (!mozeIsc(dx, dy));
           }while(dx==0 && dy==0);
                swiat.dodajKomunikat(nazwa + " rusza się z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");
                System.out.println(nazwa + " rusza się z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");
               if(dx!=0 || dy!=0) idz(x + dx, y + dy);
        }
        else{
            Random rand=new Random();
            int dx, dy;
            do {
                do {
                    dx = 0;
                    dy = 0;
                    for(int i=0; i<2; i++) {
                        int pom = rand.nextInt(6);
                        //L
                        if (pom == 0) {
                            dx--;
                        }
                        //LU
                        else if (pom == 1) {
                            if (y % 2 == 0) {
                                dy--;
                                dx--;
                            } else {
                                dy--;
                                dx = 0;
                            }
                        }
                        //RU
                        else if (pom == 2) {
                            if (y % 2 == 0) {
                                dy--;
                                dx = 0;
                            } else {
                                dy--;
                                dx++;
                            }
                        }
                        //R
                        else if (pom == 3) {
                            dx++;
                        }
                        //RD
                        else if (pom == 4) {
                            if (y % 2 == 0) {
                                dy++;
                                dx = 0;
                            } else {
                                dy++;
                                dx++;
                            }
                        }
                        //LD
                        else if (pom == 5) {
                            if (y % 2 == 0) {
                                dy++;
                                dx--;
                            } else {
                                dy++;
                                dx = 0;
                            }
                        }
                    }

                } while (!mozeIsc(dx,dy));
            }while(dx==0 && dy==0);
            swiat.dodajKomunikat(nazwa + " rusza się z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");
            System.out.println(nazwa + " rusza się z (" + x + "," + y + ") na (" + (x + dx) + "," + (y + dy) + ")");
            if(dx!=0 || dy!=0) idz(x + dx, y + dy);
        }
    }

    @Override
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca) {
        Random rand = new Random();
        if (swiat.zwrocTypSwiata() == TypSwiata.ZWYKLY) {
            if (rand.nextInt(1) == 0) {
                int dx, dy;
                boolean fu = false, fd = false, fl = false, fr = false, f;
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
                        fu = true;
                    } else if (pom == 3) {
                        dy = -1;
                        fd = true;
                    }
                    f = fr && fl && fu && fd;
                    if (this.mozeRozmnozyc(dx, dy)) break;
                } while (!f);
                if (f == false && (dx != 0 || dy != 0) && this.mozeRozmnozyc(dx, dy)) {
                    idz(x + dx, y + dy);
                } else if (f == true) {
                    System.out.println("Antylopa nie ma miejsca by uciec!");
                    return false;
                }
                System.out.println("Antylopa ucieka!");
                return true;
            } else {
                System.out.println("Antylopa nie ucieka!");
                return false;
            }
        } else {
            if (rand.nextInt(1) == 0) {
                int dx, dy;
                boolean flu = false, fru = false, fl = false, fr = false, fld = false, frd = false, f;
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
                    if (this.mozeRozmnozyc(dx, dy)) break;
                } while (!f);
                if (f == false && (dx != 0 || dy != 0) && this.mozeRozmnozyc(dx, dy)) {
                    idz(x + dx, y + dy);
                } else if (f == true) {
                    System.out.println("Antylopa nie ma miejsca by uciec!");
                    return false;
                }
                System.out.println("Antylopa ucieka!");
                return true;
            } else {
                System.out.println("Antylopa nie ucieka!");
                return false;
            }
        }
    }
    public void dodaj(int x, int y){
        Organizm o=new Antylopa(x,y,swiat);
        swiat.ustawPole(o);
        swiat.doDodania(o);

    }
}
