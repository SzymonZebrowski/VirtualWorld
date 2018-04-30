import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Okno implements ActionListener {
   JFrame f;
   Panel p;
   JTextField t;
   JButton bZapisz, bWczytaj, bNowaTura, bUmiejetnosc;
   Graphics2D g2d;

   Okno(Swiat swiat){
        f=new JFrame("Swiat!");
        p=new Panel(swiat);
        t=new JTextField();
        bZapisz=new JButton("Zapisz");
        bWczytaj=new JButton("Wczytaj");
        bNowaTura=new JButton("Nowa tura");
        bUmiejetnosc=new JButton("Umiejetnosc");



        f.add(t);
        f.add(bZapisz);
        f.add(bWczytaj);
        f.add(bNowaTura);
        f.add(bUmiejetnosc);
        f.add(p);
        f.pack();

        //p.setBounds(10,100,10*swiat.zwrocSzerokosc(), 10*swiat.zwrocWysokosc());
        bZapisz.setBounds(10,10,120,30);
        bWczytaj.setBounds(160,10,120,30);
        bNowaTura.setBounds(310,10,120,30);
        bUmiejetnosc.setBounds(460,10,120,30);

        t.setText(""+swiat.zwrocSzerokosc());

        f.setLayout(null);
        f.setVisible(true);
        if(20*swiat.zwrocSzerokosc()>590){
            f.setSize(20*swiat.zwrocSzerokosc() + 40, 20*swiat.zwrocWysokosc()+100);
            System.out.println("Tak");
        }
        else f.setSize(610, 20*swiat.zwrocWysokosc()+100);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // f.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){

    }

    public void paintComponent(Graphics g){
       Graphics2D g2d = (Graphics2D)g;
    }
}
