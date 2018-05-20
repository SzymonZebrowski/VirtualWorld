package world;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import world.organizmy.Czlowiek;

class Okno implements ActionListener, MouseListener, KeyListener{
    TuraGraczaOkno f;
    JFrame fZapisz, fWczytaj;

   Panel p;
   JButton bZapisz, bWczytaj, bNowaTura, bUmiejetnosc, bLegenda;
   JButton bLU, bL, bLD, bR, bRU, bRD;
   JList jl;
   DefaultListModel dlm;
   JScrollPane jsp;
   Swiat swiat;
   String nazwaPliku, kierunekGracza;

   int pozostalo,trwanie;
   boolean umiejetnosc;

   Okno(Swiat s){
       this.swiat=s;
       f=new TuraGraczaOkno();
       p=new Panel(swiat);
       bZapisz=new JButton("Zapisz");
       bWczytaj=new JButton("Wczytaj");
       bNowaTura=new JButton("Nowa tura");
       bUmiejetnosc=new JButton("Umiejetnosc");
       bLegenda=new JButton("Legenda");
       dlm=new DefaultListModel();
       jl=new JList(dlm);
       jsp=new JScrollPane(jl);

       if(swiat.zwrocTypSwiata()==TypSwiata.HEX){
           bR=new JButton();
           bRU=new JButton();
           bRD=new JButton();
           bL=new JButton();
           bLU=new JButton();
           bLD=new JButton();
           bR.setIcon(new ImageIcon("img/bR.png"));
           bRD.setIcon(new ImageIcon("img/bRD.png"));
           bRU.setIcon(new ImageIcon("img/bRU.png"));
           bL.setIcon(new ImageIcon("img/bL.png"));
           bLD.setIcon(new ImageIcon("img/bLD.png"));
           bLU.setIcon(new ImageIcon("img/bLU.png"));
           f.add(bR);
           f.add(bRD);
           f.add(bRU);
           f.add(bL);
           f.add(bLD);
           f.add(bLU);


           bLU.setBounds(430,90+15*swiat.zwrocWysokosc(),40,40);
           bL.setBounds(410,90+15*swiat.zwrocWysokosc()+40,40,40);
           bLD.setBounds(430,90+15*swiat.zwrocWysokosc()+80,40,40);
           bRU.setBounds(470,90+15*swiat.zwrocWysokosc(),40,40);
           bR.setBounds(490,90+15*swiat.zwrocWysokosc()+40,40,40);
           bRD.setBounds(470,90+15*swiat.zwrocWysokosc()+80,40,40);

           bLU.addActionListener(this);
           bLD.addActionListener(this);
           bL.addActionListener(this);
           bRU.addActionListener(this);
           bRD.addActionListener(this);
           bR.addActionListener(this);

       }
       umiejetnosc=false;
       pozostalo=0;
       trwanie=0;

       f.add(bZapisz);
       f.add(bWczytaj);
       f.add(bNowaTura);
       f.add(bUmiejetnosc);
       f.add(bLegenda);
       f.add(jsp);
       f.add(p);
       f.pack();


       bZapisz.setBounds(10,10,120,30);
       bWczytaj.setBounds(160,10,120,30);
       bNowaTura.setBounds(310,10,120,30);
       bUmiejetnosc.setBounds(460,10,120,30);
       bLegenda.setBounds(610,10,120,30);
       if(swiat.zwrocTypSwiata()== TypSwiata.HEX) {
           jsp.setBounds(10, 100 + 15 * swiat.zwrocWysokosc(), 400, 100);
       }
       else{
           jsp.setBounds(10, 100 + 20 * swiat.zwrocWysokosc(), 400, 100);

       }

       bZapisz.addActionListener(this);
       bWczytaj.addActionListener(this);
       bNowaTura.addActionListener(this);
       bUmiejetnosc.addActionListener(this);
       bLegenda.addActionListener(this);
       f.addMouseListener(this);
       f.addKeyListener(this);



       f.setLayout(null);
       f.setVisible(true);
       if(20*swiat.zwrocSzerokosc()>740){
           if(swiat.zwrocTypSwiata()== TypSwiata.HEX) {
               f.setSize(20*swiat.zwrocSzerokosc() + 40, 15*swiat.zwrocWysokosc()+250);
           }
           else{
               f.setSize(20*swiat.zwrocSzerokosc() + 40, 20*swiat.zwrocWysokosc()+250);

           }
       }
       else {
           if(swiat.zwrocTypSwiata()== TypSwiata.HEX) {
               f.setSize(760, 15*swiat.zwrocWysokosc()+250);
           }
           else{
               f.setSize(760, 20*swiat.zwrocWysokosc()+250);

           }
       }

       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
       jl.setSelectedIndex(0);
       jl.setVisibleRowCount(5);
       // f.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bZapisz) {
            fZapisz=new JFrame("Zapisywanie");
            nazwaPliku=JOptionPane.showInputDialog(fZapisz, "Podaj nazwę pliku");
            if(nazwaPliku!=null) {
                try {
                    swiat.zapisz(nazwaPliku);
                } catch (IOException e) {
                    System.out.println("Błąd przy zapisywaniu");
                }
            }
        }
        else if(ae.getSource()==bWczytaj) {
            fWczytaj=new JFrame("Wczytywanie");
            nazwaPliku=JOptionPane.showInputDialog(fWczytaj, "Podaj nazwę pliku");
            System.out.println("Stara szerokosc i wysokosc: "+swiat.zwrocSzerokosc()+" "+swiat.zwrocWysokosc());
            if(nazwaPliku!=null) {
                try {
                    swiat.wczytaj(nazwaPliku);
                } catch (IOException e) {
                    System.out.println("Błąd przy wczytywaniu");
                }
                f.repaint();
            }
            System.out.println("Nowa szerokosc i wysokosc: "+swiat.zwrocSzerokosc()+" "+swiat.zwrocWysokosc());

            if(20*swiat.zwrocSzerokosc()>740){
                f.setSize(20*swiat.zwrocSzerokosc() + 40, 20*swiat.zwrocWysokosc()+250);
            }
            else f.setSize(760, 20*swiat.zwrocWysokosc()+250);
            p.setBounds(0,0,20*swiat.zwrocSzerokosc()+40,20*swiat.zwrocWysokosc()+60);
            jsp.setBounds(10,100+20*swiat.zwrocWysokosc(),250,100);

        }
        else if(ae.getSource()==bNowaTura) {
            wykonajTure();
        }
        else if(ae.getSource()==bUmiejetnosc)  {
            if(umiejetnosc==false && pozostalo==0) {
            addComunicate("Aktywowano umiejętność");
            umiejetnosc=true;
            pozostalo=5;
            trwanie=5;
            }
        }
        else if(ae.getSource()==bLegenda){
            JFrame fLegenda=new JFrame("Legenda");
            LegendPanel lpLegenda=new LegendPanel();

            String organizmy[]={"Owca","Wilk", "Lis", "Żółw", "Antylopa", "Człowiek",
                    "Trawa", "Guarana", "Wilcza Jagoda", "Barszcz", "Mlecz"};
           // JLabel label[]=new JLabel[11];

            for(int i=0; i<11; i++){
                JLabel label=new JLabel();
                label.setText(organizmy[i]);
                label.setBounds(50,10+20*i,150,20);
                fLegenda.add(label);
            }
            fLegenda.add(lpLegenda);

            fLegenda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fLegenda.setSize(200,300);
           // fLegenda.pack();
            fLegenda.setVisible(true);

        }
        else if(ae.getSource()==bL) {kierunekGracza="L"; wykonajTure();}
        else if(ae.getSource()==bLD) {kierunekGracza="LD"; wykonajTure();}
        else if(ae.getSource()==bLU) {kierunekGracza="LU"; wykonajTure();}
        else if(ae.getSource()==bR) {kierunekGracza="R"; wykonajTure();}
        else if(ae.getSource()==bRD) {kierunekGracza="RD"; wykonajTure();}
        else if(ae.getSource()==bRU) {kierunekGracza="RU"; wykonajTure();}
        f.requestFocus();

    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){
       int mouseX=e.getX();
       int mouseY=e.getY();
       if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY) {
           if (mouseX < 20 * swiat.zwrocSzerokosc() + 20 && mouseY < 20 * swiat.zwrocWysokosc() + 80
                   && mouseX > 20 && mouseY > 80) { //jeżeli jest w granicach planszy
               int x = (mouseX - 20) / 20;
               int y = (mouseY - 80) / 20;
               dodajOrganizm(x,y);
           }
       }else{
           if (mouseY < 15 * swiat.zwrocWysokosc() + 85 && mouseY > 85) {
                int y=(mouseY-85)/15;
               if(y%2==0){
                   if (mouseX < (int)p.hexWidth * swiat.zwrocSzerokosc() + 20 && mouseX > 20) {
                       int x=(mouseX-20)/(int)p.hexWidth;
                       dodajOrganizm(x,y);
                   }
               }
               else{
                   if ((mouseX < (int)p.hexWidth * swiat.zwrocSzerokosc() + (int)p.hexWidth/2 + 20) && (mouseX > (int)p.hexWidth/2 + 20)) {
                       int x=(mouseX-20-(int)p.hexWidth/2)/(int)p.hexWidth;
                       dodajOrganizm(x,y);
                   }
               }

           }
       }

    }
    @Override
    public void keyTyped(KeyEvent k){ int key=k.getKeyCode();
        if(key==KeyEvent.VK_UP) System.out.println("UP");
        if(key==KeyEvent.VK_DOWN) System.out.println("DOWN");
        if(key==KeyEvent.VK_LEFT) System.out.println("LEFT");
        if(key==KeyEvent.VK_RIGHT) System.out.println("RIGHT");

    }
    @Override
    public void keyReleased(KeyEvent k){
    }
    @Override
    public void keyPressed(KeyEvent k){
        int key=k.getKeyCode();
        if(swiat.zwrocTypSwiata()==TypSwiata.ZWYKLY) {
            if (key == KeyEvent.VK_UP) {kierunekGracza = "UP"; wykonajTure();}
            if (key == KeyEvent.VK_DOWN) {kierunekGracza = "DOWN"; wykonajTure();}
            if (key == KeyEvent.VK_LEFT) {kierunekGracza = "LEFT"; wykonajTure();}
            if (key == KeyEvent.VK_RIGHT) {kierunekGracza = "RIGHT"; wykonajTure();}
        }
    }

    public void addComunicate(String s){
       dlm.addElement(s);
    }

    public void deleteComunicate(){
       dlm.removeAllElements();
    }

    public void ustawNiesmiertelnosc(boolean s){umiejetnosc=s;}
    public void ustawTrwanie(int s){trwanie=s;}
    public void ustawCzekanie(int s){pozostalo=s;}

    public void wykonajTure(){
        this.swiat.wykonajTure();
        if(umiejetnosc==true){
            if(trwanie>0)trwanie--;
            addComunicate("Pozostało "+trwanie+" tur umiejętności");
        }
        if(trwanie==0){
            umiejetnosc=false;
            if(pozostalo>0){
                addComunicate("Pozostało "+pozostalo+" tur oczekiwania");
                pozostalo--;
            }
        }
        this.f.repaint();
    }
    public void dodajOrganizm(int x, int y) {
        if (swiat.czyPuste(x, y)) {
            final String[] organizmy = {"Lis", "Wilk", "Owca", "Antylopa", "Żółw", "Trawa", "Mlecz", "Guarana", "Wilcza Jagoda", "Barszcz"};
            System.out.println(x + " " + y);
            JFrame fDodaj = new JFrame("Dodawanie organizmu");
            String org = (String) JOptionPane.showInputDialog(fDodaj, "Jaki organizm chcesz dodać?", "Pole (" + x + "," + y + ")", JOptionPane.QUESTION_MESSAGE,
                    null, organizmy, organizmy[0]);
            if (org != null) {
                char o = org.charAt(0);
                if (org == "Lis") o = 'l';
                else if (org == "Wilk") o = 'w';
                else if (org == "Owca") o = 'o';
                else if (org == "Antylopa") o = 'a';
                else if (org == "Żółw") o = 'z';

                swiat.dodajZeZnaku(o, x, y);
                f.repaint();
            }
        }
    }
}
