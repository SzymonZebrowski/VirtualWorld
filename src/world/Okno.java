package world;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Okno implements ActionListener {
   JFrame f;
   Panel p;
   JButton bZapisz, bWczytaj, bNowaTura, bUmiejetnosc, bWyczysc, bStanSwiata;
   JList jl;
   DefaultListModel dlm;
   JScrollPane jsp;
   Swiat swiat;

   Okno(Swiat s){
        this.swiat=s;
        f=new JFrame("Swiat!");
        p=new Panel(swiat);
        bZapisz=new JButton("Zapisz");
        bWczytaj=new JButton("Wczytaj");
        bNowaTura=new JButton("Nowa tura");
        bUmiejetnosc=new JButton("Umiejetnosc");
        bWyczysc=new JButton("Wyczysc");
        bStanSwiata=new JButton("Stan Swiata");
        dlm=new DefaultListModel();
        jl=new JList(dlm);
        jsp=new JScrollPane(jl);

        f.add(bZapisz);
        f.add(bWczytaj);
        f.add(bNowaTura);
        f.add(bUmiejetnosc);
        f.add(bWyczysc);
        f.add(bStanSwiata);
        f.add(jsp);
        f.add(p);
        f.pack();

        bZapisz.setBounds(10,10,120,30);
        bWczytaj.setBounds(160,10,120,30);
        bNowaTura.setBounds(310,10,120,30);
        bUmiejetnosc.setBounds(460,10,120,30);
        bWyczysc.setBounds(460,50,120,30);
        bStanSwiata.setBounds(460,90,120,30);
        jsp.setBounds(10,100+20*swiat.zwrocWysokosc(),250,100);

        bZapisz.addActionListener(this);
        bWczytaj.addActionListener(this);
        bNowaTura.addActionListener(this);
        bUmiejetnosc.addActionListener(this);
        bWyczysc.addActionListener(this);
        bStanSwiata.addActionListener(this);


        f.setLayout(null);
        f.setVisible(true);
        if(20*swiat.zwrocSzerokosc()>590){
            f.setSize(20*swiat.zwrocSzerokosc() + 40, 20*swiat.zwrocWysokosc()+250);
        }
        else f.setSize(610, 20*swiat.zwrocWysokosc()+250);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jl.setSelectedIndex(0);
        jl.setVisibleRowCount(5);
       // f.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bZapisz) System.out.println("Zapisz!");
        else if(ae.getSource()==bWczytaj) System.out.println("Wczytaj!");
        else if(ae.getSource()==bNowaTura) {this.swiat.wykonajTure(); this.f.repaint();}
        else if(ae.getSource()==bUmiejetnosc) System.out.println("Umiejętność!");
        else if(ae.getSource()==bWyczysc) dlm.removeAllElements();
        else if(ae.getSource()==bStanSwiata){
            for(int i=0; i<swiat.zwrocWysokosc(); i++){
                for(int j=0; j<swiat.zwrocSzerokosc(); j++){
                   if(swiat.zwrocOrganizm(j,i)==null) System.out.print(0);
                   else System.out.print(1);
                }
                System.out.println();
            }
        }
    }

    public void addComunicate(String s){
       dlm.addElement(s);
    }

    public void deleteComunicate(){
       dlm.removeAllElements();
    }
}
