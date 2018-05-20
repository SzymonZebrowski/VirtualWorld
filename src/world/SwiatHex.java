package world;

import world.organizmy.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SwiatHex extends Swiat {
    public void wykonajTure(){
        numerTury++;
        for(Organizm o : doDodaniaLista){
            dodajOrganizm(o);
        }
        doDodaniaLista.removeAll(doDodaniaLista);
        okno.deleteComunicate();

        czyscTablice();
        tworzTablice();

        List<Organizm>lista=null;
        for(int i=0; i<5; i++){
            switch(i){
                case 0: lista=lisLista; break;
                case 1: lista=wilkLista; break;
                case 2: lista=czlowiekOwcaAntylopaLista; break;
                case 3: lista=zolwLista; break;
                case 4: lista=roslinaLista; break;
            }
            for(Organizm o : lista){
                if(o.zwrocStan()==StanOrganizmu.ALIVE){
                    o.dorosnij();
                    o.akcja();
                }
                else if(o.zwrocStan()==StanOrganizmu.BORN) o.dorosnij();
            }
        }
    }
    public String zwrocKierunekGracza(){return okno.kierunekGracza;}
    public boolean zwrocUmiejetnosc(){return okno.umiejetnosc;}
    public int zwrocTrwanie(){return okno.trwanie;}
    public int zwrocPozostalo(){return okno.pozostalo;}
    public void ustawNiesmiertelnosc(boolean s){okno.ustawNiesmiertelnosc(s);}
    public void ustawTrwanie(int s){okno.ustawTrwanie(s);}
    public void ustawCzekanie(int s){okno.ustawCzekanie(s);}
    public void czyscTablice(){
        for(int i=0; i<wysokosc; i++){
            for(int j=0; j<szerokosc; j++){
                plansza[i][j]=null;
            }
        }
    }
    public void tworzTablice(){
        for(Organizm o : lisLista){
            if(o.zwrocStan()!=StanOrganizmu.DEAD) plansza[o.zwrocY()][o.zwrocX()]=o;
        }
        for(Organizm o : wilkLista) {
            if(o.zwrocStan()!=StanOrganizmu.DEAD) plansza[o.zwrocY()][o.zwrocX()]=o;
        }
        for(Organizm o : czlowiekOwcaAntylopaLista) {
            if(o.zwrocStan()!=StanOrganizmu.DEAD) plansza[o.zwrocY()][o.zwrocX()]=o;
        }
        for(Organizm o : zolwLista) {
            if(o.zwrocStan()!=StanOrganizmu.DEAD) plansza[o.zwrocY()][o.zwrocX()]=o;
        }
        for(Organizm o : roslinaLista) {
            if(o.zwrocStan()!=StanOrganizmu.DEAD) plansza[o.zwrocY()][o.zwrocX()]=o;
        }

    }
    public int zwrocWysokosc(){return wysokosc;}
    public int zwrocSzerokosc(){return szerokosc;}
    public void doDodania(Organizm o){
        doDodaniaLista.add(o);
        licznik++;
    }
    public void dodajOrganizm(Organizm o){
        char pom = o.zwrocZnak();
        ustawPole(o);
        if(pom=='l') lisLista.add(o);
        else if(pom=='w') wilkLista.add(o);
        else if(pom=='@' || pom=='o' || pom=='a') czlowiekOwcaAntylopaLista.add(o);
        else if(pom=='z') zolwLista.add(o);
        else if(pom=='T' || pom=='M' || pom=='G' || pom=='W' || pom=='B') roslinaLista.add(o);
    }
    public void usunOrganizmy(){
        lisLista.clear();
        wilkLista.clear();
        czlowiekOwcaAntylopaLista.clear();
        zolwLista.clear();
        roslinaLista.clear();
        doDodaniaLista.clear();
    }
    public void ustawOkno(Okno okno){this.okno=okno;}
    public void dodajKomunikat(String s){okno.addComunicate(s);}
    public boolean czyPuste(int x, int y){
        if(plansza[y][x]==null) return true;
        else return false;
    }
    public TypSwiata zwrocTypSwiata(){return typSwiata;}
    public Organizm zwrocOrganizm(int x, int y){
        return plansza[y][x];
    }
    public void zwolnijPole(int x, int y){
        plansza[y][x]=null;
    }
    public void ustawPole(Organizm org){
        plansza[org.zwrocY()][org.zwrocX()]=org;
    }
    public void zmniejszLicznik(){licznik--;}
    public void generator(int ile){
        int x, y;
        Random rand=new Random();
        for (int i = 0; i < 10; i++) {
            char z=0;
            switch(i){
                case 0: z='l'; break;
                case 1: z='w'; break;
                case 2: z='o'; break;
                case 3: z='a'; break;
                case 4: z='z'; break;
                case 5: z='T'; break;
                case 6: z='M'; break;
                case 7: z='G'; break;
                case 8: z='W'; break;
                case 9: z='B'; break;
            }
            for (int j = 0; j < ile; j++)
            {
                licznik++;
                do {
                    y = rand.nextInt(wysokosc);
                    x = rand.nextInt(szerokosc);

                } while (!czyPuste(x, y)); //losuj tak dlugo az znajdziesz wolne pole

                //na podstawie znaku dodaje organizm
                dodajZeZnaku(z,x,y);
            }
        }
    }
    public void zapisz(String plik) throws IOException {
        PrintWriter plikWy=null;
        try {
            plikWy=new PrintWriter(plik);
            plikWy.println("HEX");
            plikWy.println(szerokosc + " " + wysokosc);

            for(Organizm o: czlowiekOwcaAntylopaLista){
                if(o.zwrocZnak()=='@' && o.zwrocStan()!=StanOrganizmu.DEAD){
                    plikWy.println(o.zapiszDoPliku());
                }
            }
            List<Organizm>lista=null;
            for(int i=0; i<5; i++){
                switch(i){
                    case 0: lista=lisLista; break;
                    case 1: lista=wilkLista; break;
                    case 2: lista=czlowiekOwcaAntylopaLista; break;
                    case 3: lista=zolwLista; break;
                    case 4: lista=roslinaLista; break;
                }
                for(Organizm o : lista){
                    if(o.zwrocStan()!=StanOrganizmu.DEAD && o.zwrocZnak()!='@'){
                        plikWy.println(o.zapiszDoPliku());
                    }
                }
            }

        }
        catch(IOException exc){
            throw exc;
        }
        finally{
            if(plikWy!=null) plikWy.close();
        }
    }
    public void wczytaj(String plik) throws IOException{
        BufferedReader plikWe=null;
        try {
            plikWe=new BufferedReader(new FileReader(plik));
            Scanner sc= new Scanner(new File(plik));
            String typ=sc.next();

            if(typ.equals("HEX") && zwrocTypSwiata()==TypSwiata.HEX) {

                czyscTablice();
                usunOrganizmy();
                int wys, szer;
                szer = sc.nextInt();
                wys = sc.nextInt();
                this.wysokosc = wys;
                this.szerokosc = szer;

                this.plansza = new Organizm[wys][szer];

                char znak;
                int x, y, s, sila;
                boolean n;
                int t, c;
                StanOrganizmu stan = StanOrganizmu.BORN;
                while (sc.hasNext()) {
                    znak = sc.next().charAt(0);
                    sila = sc.nextInt();
                    x = sc.nextInt();
                    y = sc.nextInt();
                    s = sc.nextInt();
                    if (znak == '@') {
                        n = sc.nextBoolean();
                        t = sc.nextInt();
                        c = sc.nextInt();
                        if (s == 0) stan = StanOrganizmu.BORN;
                        else if (s == 1) stan = StanOrganizmu.ALIVE;
                        Organizm o = dodajZeZnaku(znak, x, y);
                        o.ustawStan(stan);
                        o.ustawSile(sila);
                        ustawNiesmiertelnosc(n);
                        ustawTrwanie(t);
                        ustawCzekanie(c);
                    } else {
                        if (s == 0) stan = StanOrganizmu.BORN;
                        else if (s == 1) stan = StanOrganizmu.ALIVE;
                        Organizm o = dodajZeZnaku(znak, x, y);
                        o.ustawStan(stan);
                        o.ustawSile(sila);
                    }
                }
            }
            sc.close();
        }
        catch(IOException exc){
            throw exc;
        }
        finally{
            if(plikWe!=null) plikWe.close();
        }
    }
    public Organizm dodajZeZnaku(char z,int x, int y){
        Organizm o=null;
        switch(z){
            case '@':
                o=new Czlowiek(x,y,this);
                break;
            case 'l':
                o=new Lis(x,y,this);
                break;
            case 'w':
                o=new Wilk(x,y,this);
                break;
            case 'a':
                o=new Antylopa(x,y,this);
                break;
            case 'o':
                o=new Owca(x,y,this);
                break;
            case 'z':
                o=new Zolw(x,y,this);
                break;
            case 'T':
                o=new Trawa(x,y,this);
                break;
            case 'M':
                o=new Mlecz(x,y,this);
                break;
            case 'B':
                o=new Barszcz(x,y,this);
                break;
            case 'G':
                o=new Guarana(x,y,this);
                break;
            case 'W':
                o=new WilczaJagoda(x,y,this);
                break;
            default:
                break;
        }
        dodajOrganizm(o);
        return o;
    }
    protected SwiatHex(int w, int h){
        super(w,h,TypSwiata.HEX);
        this.szerokosc=w;
        this.wysokosc=h;
        this.typSwiata=TypSwiata.HEX;
        this.numerTury=0;

        plansza=new Organizm[wysokosc][szerokosc];
        lisLista=new LinkedList<Organizm>();
        wilkLista=new LinkedList<Organizm>();
        czlowiekOwcaAntylopaLista=new LinkedList<Organizm>();
        zolwLista=new LinkedList<Organizm>();
        roslinaLista=new LinkedList<Organizm>();
        doDodaniaLista=new LinkedList<Organizm>();
    }
}
