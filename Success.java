package sql;
import java.awt.*;
import java.awt.event.*;
public class Success extends Frame implements ActionListener {
    Panel p1,p2,p3,p4;
    Button b1, b2,b3,b4;
    Label l;
    Frame f;
    Success() {
        f = new Frame();
        f.setTitle("Interface Exam Simulator");
        l = new Label("VALUE SUCCESSFULLY INSERTED......");
        l.setFont(new Font("Arial", Font.BOLD, 30));
        l.setForeground(Color.red);
        b1 = new Button("ADMIN HOME");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.addActionListener(this);
        b2 = new Button("LOGIN AGAIN");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.addActionListener(this);
        b3 = new Button("HOME");
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.addActionListener(this);
        b4 = new Button("EXIT");
        b4.setBackground(Color.blue);
        b4.setForeground(Color.white);
        b4.setFont(new Font("Arial", Font.BOLD, 20));
        b4.addActionListener(this);
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p1.add(l);
        p2.setLayout(new GridLayout(4, 1, 25, 10));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p3.add(p2);
        p4.setLayout(new GridLayout(2, 1, 15, 50));
        p4.add(p1);
        p4.add(p3);
        f.setLayout(new FlowLayout());
        f.add(p4);
        f.setBackground(Color.cyan);
        f.setVisible(true);
        f.setSize(1050, 1050);
        f.addWindowListener(new W());
    }
    class W extends WindowAdapter {
        public void windowClosing (WindowEvent we) {
            System.exit(0);
        }
    }
    public void actionPerformed (ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            Admin e = new Admin();
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
            Login l = new Login();
        } else if (ae.getSource()== b3) {
            f.setVisible (false);
            Home h=new Home();
        } else if (ae.getSource () ==b4) {
            f.setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String [] args) {
        Success s=new Success();
    }
}