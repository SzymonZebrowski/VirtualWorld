package world;
import world.organizmy.StanOrganizmu;

public abstract class Organizm {

    protected Swiat swiat;
    protected StanOrganizmu stan;
    protected boolean niesmiertelnosc;
    protected int sila;
    protected int inicjatywa;
    protected int wiek;
    protected int x,y; //obecne polozenie
    protected int px, py;//ostatnie polozenie
    protected String nazwa;
    protected char znak;

    public int zwrocSile(){return sila;}
    public int zwrocInicjatywe(){return inicjatywa;}
    public String zwrocNazwe(){return nazwa;}
    public char zwrocZnak(){return znak;}
    public int zwrocX(){return x;}
    public int zwrocY(){return y;}
    public StanOrganizmu zwrocStan(){return stan;}
    public void ustawSile(int s){sila=s;}
    public void ustawStan(StanOrganizmu s){stan=s;}
    public void ustawNiesmiertelnosc(boolean s){}
    public void ustawTrwanie(int s){}
    public void ustawCzekanie(int s){}
    public void dorosnij(){wiek++; stan=StanOrganizmu.ALIVE;}
    public void akcja(){}
    abstract public void kolizja(Organizm atakujacy, Organizm obronca);
    abstract public void walcz(Organizm atakujacy, Organizm obronca);
    abstract public void rozmnoz(Organizm atakujacy, Organizm obronca);
    abstract public boolean mozeIsc(int dx, int dy);
    abstract public boolean mozeRozmnozyc(int dx, int dy);
    public boolean umiejetnosc(Organizm atakujacy, Organizm obronca){return false;}
    public boolean czyNiesmiertelny(){return niesmiertelnosc;}
    public String zapiszDoPliku(){
        String str;
        int s=0;
        if(stan==StanOrganizmu.BORN) s=0;
        else if(stan==StanOrganizmu.ALIVE) s=1;
        str=znak+" "+sila+" "+x+" "+y+" "+s;
        return str;
    }

    public Organizm(int x, int y, Swiat swiat){
        this.x=x;
        this.y=y;
        this.px=x;
        this.py=y;
        this.swiat=swiat;
        this.wiek=0;
        this.stan=StanOrganizmu.BORN;
        this.niesmiertelnosc=false;
    }

}
