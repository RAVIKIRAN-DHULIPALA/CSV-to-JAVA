import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class Results implements ActionListener {
    JTextField tf1;
    JButton b1;
    JFrame f= new JFrame("Results");
    public Results(){
        tf1=new JTextField();
        tf1.setBounds(50,50,150,20);
        b1=new JButton("check");
        b1.setBounds(85,100,70,50);
        b1.addActionListener(this);
        f.add(tf1);
        f.add(b1);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            String s1 = tf1.getText();
            try {
                getResults(s1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    public void getResults(String pin) throws Exception{
        final JPanel panel = new JPanel();
        final JPanel p1=new JPanel();
        final JPanel p2=new JPanel();
        final JPanel p3= new JPanel();
        BufferedReader br= new BufferedReader(new FileReader("./file.csv"));
        String line="";
        String a="";
        p1.setLayout(new GridLayout(0,1,5,40));
        p2.setLayout(new GridLayout(0,1,5,40));
        p3.setLayout(new GridLayout(0,1,5,40));
        while((line=br.readLine())!=null){
            String b[]=line.split(",");
            if (b.length!=0)
                a=b[0];
            if (a.equals(pin)) {
                for (int i=2;i<b.length;i+=3){
                    JLabel _lbl = new JLabel();
                    _lbl.setText(b[i]);
                    p1.add(_lbl);
                    p1.revalidate();
                    p1.repaint();
                }
                for (int i=3;i<b.length;i+=3){
                    JLabel _lbl = new JLabel();
                    _lbl.setText("\t\t\t\t"+b[i]);
                    p2.add(_lbl);
                    p2.revalidate();
                    p2.repaint();
                }
                for (int i=4;i<b.length;i+=3){
                    JLabel _lbl = new JLabel();
                    _lbl.setText(b[i]);
                    p3.add(_lbl);
                    p3.revalidate();
                    p3.repaint();
                }
            }
            panel.setLayout(new GridLayout(0,3,10,20));
            panel.add(p1);
            panel.add(p2);
            panel.add(p3);
            panel.setBounds(550,50,1000,500);
            f.add(panel);
        }

    }

    public static void main(String[] args) {
        new Results();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

    }
}
