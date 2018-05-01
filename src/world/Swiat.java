package world;
import world.organizmy.StanOrganizmu;
import world.TypSwiata;
import world.*;

import javax.swing.*;
import java.util.List;
import java.util.LinkedList;

public class Swiat {

    public void wykonajTure(){
        /*for(Organizm o : lisLista){
            if(o.zwrocStan()==StanOrganizmu.ALIVE){
                o.dorosnij();
                o.akcja();
            }
            else if(o.zwrocStan()==StanOrganizmu.BORN) o.dorosnij();
        }
        for(Organizm o : wilkLista){
            if(o.zwrocStan()==StanOrganizmu.ALIVE){
                o.dorosnij();
                o.akcja();
            }
            else if(o.zwrocStan()==StanOrganizmu.BORN) o.dorosnij();
        }
        for(Organizm o : czlowiekOwcaAntylopaLista){
            if(o.zwrocStan()==StanOrganizmu.ALIVE){
                o.dorosnij();
                o.akcja();
            }
            else if(o.zwrocStan()==StanOrganizmu.BORN) o.dorosnij();
        }
        for(Organizm o : zolwLista){
            if(o.zwrocStan()==StanOrganizmu.ALIVE){
                o.dorosnij();
                o.akcja();
            }
            else if(o.zwrocStan()==StanOrganizmu.BORN) o.dorosnij();
        }
        for(Organizm o : roslinaLista){
            if(o.zwrocStan()==StanOrganizmu.ALIVE){
                o.dorosnij();
                o.akcja();
            }
            else if(o.zwrocStan()==StanOrganizmu.BORN) o.dorosnij();
        }*/
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
    public void czyscTablice(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
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
    public int zwrocWysokosc(){return height;}
    public int zwrocSzerokosc(){return width;}
    public void dodajOrganizm(Organizm o){
        char pom = o.zwrocZnak();
        if(pom=='l') lisLista.add(o);
        else if(pom=='w') wilkLista.add(o);
        else if(pom=='@' || pom=='o' || pom=='a') czlowiekOwcaAntylopaLista.add(o);
        else if(pom=='z') zolwLista.add(o);
        else if(pom=='T' || pom=='M' || pom=='G' || pom=='W' || pom=='B') roslinaLista.add(o);
    }
    public void symuluj(int ile){}
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

    protected Swiat(int w, int h, TypSwiata typ){
        this.width=w;
        this.height=h;
        this.typSwiata=typ;
        this.numerTury=0;
        plansza=new Organizm[height][width];
        lisLista=new LinkedList<Organizm>();
        wilkLista=new LinkedList<Organizm>();
        czlowiekOwcaAntylopaLista=new LinkedList<Organizm>();
        zolwLista=new LinkedList<Organizm>();
        roslinaLista=new LinkedList<Organizm>();

        czyscTablice();
        tworzTablice();
    }

    public Okno okno;
    protected int width, height;
    protected int numerTury;
    protected TypSwiata typSwiata;
    protected Organizm[][] plansza;
    protected List<Organizm> lisLista;
    protected List<Organizm> wilkLista;
    protected List<Organizm> czlowiekOwcaAntylopaLista;
    protected List<Organizm> zolwLista;
    protected List<Organizm> roslinaLista;

}
