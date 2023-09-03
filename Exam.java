package sql;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Exam extends Frame implements ActionListener, ItemListener, ComponentListener, Runnable {
    TextArea ta;
    Button next;
    Panel p, p0, p1, p2, p3, p4, p5;
    Checkbox a,b,c,d;
    CheckboxGroup cbg;
    TextField tf1;
    Label l, l0, l1, l2, l3, l4, l5;
    Frame f;
    Thread t1;
    String [][] opt = new String[10][5];
    static String [] que = new String[10];
    static boolean [] ans = new boolean[10];
    int [] seq = new int[10];
    static String chp="", timing="";
    int nxt=1, index =0, n=1, mark=0;
    static int marks, attempt;
    String option ="", check="";
    Exam() {
        f = new Frame();
        f.setTitle("Exam");
        p = new Panel();
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();

        l = new Label("Question : ");
        l.setBackground(Color.white);
        l.setForeground(Color.blue);
        l.setFont(new Font("Arial", Font.BOLD, 15));
        l3 = new Label("1");
        l3.setBackground(Color.white);
        l3.setForeground(Color.red);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        l0 = new Label("Clock");
        l0.setBackground(Color.white);
        l0.setForeground(Color.blue);
        l0.setFont(new Font("Arial", Font.BOLD, 15));
        l1 = new Label("");
        l1.setBackground(Color.white);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l2 = new Label("Time :");
        l2.setBackground(Color.white);
        l2.setForeground(Color.blue);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l4 = new Label("30 Minutes");
        l4.setBackground(Color.white);
        l4.setForeground(Color.red);
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p0.setLayout(new FlowLayout(FlowLayout.RIGHT));
        p1.add(l);
        p1.add(l3);
        p1.add(l0);
        p0.add(l2);
        p0.add(l4);
        p.setLayout(new BorderLayout());
        p.setBackground(Color.white);
        p.add(p1, BorderLayout.WEST);
        p.add(l1);
        p.add(p0, BorderLayout.EAST);
        ta = new TextArea(50, 50);
        ta.setForeground(Color.blue);
        ta.setFont(new Font("Arial", Font.BOLD, 15));
        p2.setLayout(new GridLayout(2,1));
        p2.add(ta);
        cbg = new CheckboxGroup();
        a =new Checkbox("A", cbg, false);
        a.setForeground(Color.blue);
        a.setFont(new Font("Arial", Font.BOLD, 15));
        a.addItemListener(this);
        b =new Checkbox("B", cbg, false);
        b.setForeground(Color.blue);
        b.setFont(new Font("Arial", Font.BOLD, 15));
        b.addItemListener(this);
        c =new Checkbox("A", cbg, false);
        c.setForeground(Color.blue);
        c.setFont(new Font("Arial", Font.BOLD, 15));
        c.addItemListener(this);a =new Checkbox("A", cbg, false);
        d = new Checkbox("D", cbg, false);
        d.setForeground(Color.blue);
        d.setFont(new Font("Arial", Font.BOLD, 15));
        d.addItemListener(this);
        p3.setLayout(new GridLayout(4,1,5,0));
        p3.add(a);
        p3.add(b);
        p3.add(c);
        p3.add(d);
        p2.add(p3);
        next = new Button("NEXT");
        next.setBackground(Color.yellow);
        next.setForeground(Color.blue);
        next.setFont(new Font("Arial", Font.BOLD, 15));
        next.addActionListener(this);
        p4.add(next);
        p5.setLayout(new GridLayout(4,1));
        f.add(p, BorderLayout.NORTH);
        f.add(p2);
        f.add(p4, BorderLayout.SOUTH);
        f.addComponentListener(this);
        f.setBackground(Color.cyan);
        f.setVisible(true);
        f.setSize(1050, 700);
    }
    public void componentShown(ComponentEvent ce) {
        Exam.chp = Chapter.chp;
        try {
            connect();
        } catch(Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
        t1 = new Thread(this);
        t1.start();
    }
    public void componentResized(ComponentEvent ce) {}
    public void componentMoved(ComponentEvent ce) {}
    public void componentHidden(ComponentEvent ce) {}
    public void run() {
        int minute = 0, second = 0;
        for(;;) {
            try {
                timing=minute+" : "+ Integer.toString(second);
                l1.setText(timing);
                second++;
                if(minute==30) {
                    marks = mark;
                    f.setVisible(false);
                    Result r = new Result();
                    break;
                }
                if(second==60) {
                    minute++;
                    second=0;
                }
                Thread.sleep(1000);
            } catch(InterruptedException ie) {
                System.out.println("Error : "+ie.getMessage());
            }
        }
    }
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg","root","root");
            Statement st = con.createStatement();
            ResultSet rsl = st.executeQuery("select * from "+chp);
            System.out.println(chp);
            int i=0;
            while(rsl.next()) {
               seq[i] = rsl.getInt("s1_no");
               que[i] = rsl.getString(chp+"_que");
               for(int j=0;j<5;j++) {
                   String col="";
                   if(j==4) {
                       col="ans";
                   } else {
                       col="opt"+(j+1);
                   }
                   StringBuffer sb = new StringBuffer(rsl.getString(col));
                   sb.deleteCharAt(sb.length()-1);
                   opt[i][j]=sb.toString();
               }
               i++;
               ta.setText(que[0]);
               a.setLabel(opt[0][0]);
               b.setLabel(opt[0][1]);
               c.setLabel(opt[0][2]);
               d.setLabel(opt[0][3]);
            }
            con.close();
            st.close();
        } catch(Exception e) {
            System.out.println("Caught : "+e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==next) {
            if(!check.isEmpty()) {
                attempt++;
            }
            if(check.equals(opt[index][4])) {
                ans[index]=true;
            } else {
                ans[index]=false;
            }
            check="";
            cbg.setSelectedCheckbox(null);
            n++;
            if(nxt<10) {
                l3.setText(""+n);
                ta.setText(que[nxt]);
                a.setLabel(opt[nxt][0]);
                b.setLabel(opt[nxt][1]);
                c.setLabel(opt[nxt][2]);
                d.setLabel(opt[nxt][3]);
                index=nxt;
                nxt++;
            } else {
                marks=mark;
                f.setVisible(false);
                Res r = new Res();
            }
        }
    }
    public void itemStateChanged(ItemEvent ie) {
        option = cbg.getSelectedCheckbox().getLabel();
        check = ""+option.charAt(0);
        if(check.equals(opt[index][4])) {
            marks++;
        }
    }
}
