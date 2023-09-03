package sql;
import java.awt.*;
import java.awt.event.*;
public class Res extends Frame {
    Label lb1, lb2, l, l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    Label [] lbl1 = new Label[10];
    Label [] lbl2 = new Label[10];
    Panel p1, p2, p3, p4, p5, p6;
    int mark, attempt;
    boolean b = true;
    char c;
    String res = "", timing="", min="", sec="";
    String [] que = new String[10];
    boolean [] ans = new boolean[10];
    Frame f;
    Res() {
        f = new Frame();
        f.setTitle("Interface Exam Simulator");
        que = Exam.que;
        ans = Exam.ans;
        mark= Exam.marks;
        attempt=Exam.attempt;
        timing= Exam.timing;
        if(mark>5) {
            res="PASS";
        } else {
            res="FAIL";
        }
        for(int i=0;i<timing.length();i++) {
            if((c=timing.charAt(i))==':') {
                b=false;
                continue;
            }
            if(b) {
                min+=c;
            } else {
                sec+=c;
            }
        }
        p1=new Panel();
        p2=new Panel();
        p3=new Panel();
        p4=new Panel();
        p5=new Panel();
        p6=new Panel();
        lb1 = new Label("Interface Exam Simulator");
        lb1.setBackground(Color.red);
        lb1.setForeground(Color.white);
        lb1.setFont(new Font("Arial", Font.BOLD, 25));
        p1.setBackground(Color.red);
        p1.add(lb1);
        l=new Label("Result");
        l.setBackground (Color.yellow);
        l.setForeground (Color.blue);
        l.setFont(new Font("Arial", Font. BOLD, 15));
        l0=new Label (res);
        l0.setBackground (Color.yellow);
        l0.setForeground (Color.red);
        l0.setFont(new Font ("Arial", Font. BOLD, 15));
        l1=new Label ("Your Score");
        l1.setBackground (Color.yellow);
        l1.setForeground (Color.blue);
        l1.setFont(new Font("Arial", Font. BOLD, 15));
        l2 = new Label(Integer.toString (mark*5));
        l2.setBackground (Color.yellow);
        l2.setForeground (Color.red);
        l2.setFont (new Font("Arial", Font. BOLD, 15));
        l3=new Label ("Maximum Score");
        l3.setBackground (Color.yellow);
        l3.setForeground (Color.blue);
        l3.setFont(new Font("Arial", Font. BOLD, 15));
        l4=new Label("50");
        l4.setBackground (Color.yellow);
        l4.setForeground (Color.red);
        l4.setFont(new Font("Arial", Font. BOLD, 15));
        l5=new Label("Questions Attempted");
        l5.setBackground (Color.yellow);
        l5.setForeground (Color.blue);
        l5.setFont(new Font("Arial", Font.BOLD,15));
        l6=new Label (Integer.toString (attempt));
        l6.setBackground (Color.yellow);
        l6. setForeground (Color.red);
        l6. setFont (new Font("Arial", Font. BOLD, 15));
        l7=new Label ("Correct");
        l7.setBackground (Color.yellow);
        l7.setForeground (Color.blue);
        l7. setFont(new Font("Arial", Font. BOLD,15));
        l8 = new Label(Integer.toString(mark));
        l8.setBackground (Color.yellow);
        l8.setForeground (Color.red);
        l8.setFont (new Font("Arial", Font. BOLD, 15));
        l9=new Label ("Wrong");
        l9.setBackground (Color.yellow);
        l9. setForeground (Color.blue);
        l9. setFont (new Font("Arial", Font. BOLD, 15));
        l10=new Label(Integer.toString (10-mark));
        l10.setBackground (Color.yellow);
        l10.setForeground (Color.red);
        l10.setFont (new Font("Arial", Font. BOLD, 15));
        l11=new Label ("Time Taken");
        l11.setBackground (Color.yellow);
        l11.setForeground (Color.blue);
        l11.setFont (new Font ("Arial", Font. BOLD, 15));
        l12=new Label (min+" min "+sec+" sec");
        l12.setBackground (Color.yellow);
        l12.setForeground (Color.red);
        l12.setFont (new Font ("Arial", Font. BOLD, 15));
        p2.setLayout (new GridLayout(7,2,10,5));
        p2.add(l);
        p2.add(l0);
        p2.add(l1);
        p2.add(l2);
        p2.add (l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(l6);
        p2.add(l7);
        p2.add(l8);
        p2.add(l9);
        p2.add(l10);
        p2.add(l11);
        p2.add(l12);
        lb2=new Label("STATUS");
        lb2.setBackground (Color.black);
        lb2.setForeground (Color.yellow);
        lb2.setFont (new Font("Arial", Font. BOLD, 25));
        p4.setBackground (Color.black);
        p4.add(lb2);
        p5.setLayout (new GridLayout (2,10,10,5));
        for (int k=0;k<10;k++) {
            lbl1[k] = new Label(" ");
            lbl2[k] = new Label("" + (k + 1));
            lbl1[k].setFont(new Font("Arial", Font.BOLD, 5));
            lbl2[k].setFont(new Font("Arial", Font.BOLD, 15));
            if (ans[k]) {
                lbl1[k].setBackground(Color.green);
            } else {
                lbl1[k].setBackground(Color.red);
            }
            lbl2[k].setForeground(Color.blue);
        }
        for (int k=0;k<10;k++) {
            p5.add(lbl1[k]);
        }
        for (int k=0;k<10;k++) {
            p5.add(lbl2[k]);
        }
        p6.add(p4);
        p6.add(p5);
        f.setBackground (Color.white);
        f.setLayout(new FlowLayout());
        p3.setLayout (new BorderLayout());
        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2);
        p3.add(p6, BorderLayout.SOUTH);
        f.add(p3);
        f.addWindowListener(new W());
        f.setBackground (Color.cyan);
        f.setVisible (true);
        f.setSize(1050,1050);
    }
    class W extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
}

