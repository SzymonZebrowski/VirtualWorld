package world;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Okno implements ActionListener {
   JFrame f;
   Panel p;
   JButton bZapisz, bWczytaj, bNowaTura, bUmiejetnosc;
   JList jl;
   DefaultListModel dlm;
   JScrollPane jsp;

   Okno(Swiat swiat){
        f=new JFrame("Swiat!");
        p=new Panel(swiat);
        bZapisz=new JButton("Zapisz");
        bWczytaj=new JButton("Wczytaj");
        bNowaTura=new JButton("Nowa tura");
        bUmiejetnosc=new JButton("Umiejetnosc");
        dlm=new DefaultListModel();
        jl=new JList(dlm);
        jsp=new JScrollPane(jl);

        f.add(bZapisz);
        f.add(bWczytaj);
        f.add(bNowaTura);
        f.add(bUmiejetnosc);
        f.add(jsp);
        f.add(p);
        f.pack();

        for(int i=0; i<100; i++){
            addComunicate(String.valueOf(i));
        }
        //dlm.removeAllElements();

        bZapisz.setBounds(10,10,120,30);
        bWczytaj.setBounds(160,10,120,30);
        bNowaTura.setBounds(310,10,120,30);
        bUmiejetnosc.setBounds(460,10,120,30);
        jsp.setBounds(10,100+20*swiat.zwrocWysokosc(),250,100);

        bZapisz.addActionListener(this);
        bWczytaj.addActionListener(this);
        bNowaTura.addActionListener(this);
        bUmiejetnosc.addActionListener(this);


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
        else if(ae.getSource()==bNowaTura) System.out.println("Nowa Tura!");
        else if(ae.getSource()==bUmiejetnosc) System.out.println("Umiejętność!");
    }

    public void addComunicate(String s){
       dlm.addElement(s);
    }
}
