package sql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateA extends Dialog implements ActionListener {
    Panel p1,p2,p3;
    Label l;
    Button b;
    ValidateA(Frame f, String s, boolean mod) {
        super(f,s,mod);
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        l = new Label(Admin.msg);
        l.setForeground(Color.blue);
        l.setFont(new Font("Arial",Font.BOLD, 20));
        p1.add(l);
        b = new Button("OK");
        b.setForeground(Color.blue);
        b.setFont(new Font("Arial", Font.BOLD, 10));
        b.addActionListener(this);
        p2.add(b);
        p3.setLayout(new GridLayout(2,1,5,20));
        p3.add(p1);
        p3.add(p1);
        p3.add(p2);
        setLayout(new FlowLayout());
        add(p3);
        setBackground(Color.pink);
        setSize(200, 200);
    }
    void check() {
        p1.remove(l);
        p2.remove(b);
        p3.remove(p1);
        p3.remove(p2);
        remove(p3);
        l = null;
        p1 = null;
        p2 = null;
        p3 = null;
        b = null;
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        l = new Label(Admin.msg);
        l.setForeground(Color.blue);
        l.setFont(new Font("Arial", Font.BOLD, 10));
        p1.add(l);
        b = new Button("OK");
        b.setForeground(Color.blue);
        b.setFont(new Font("Arial", Font.BOLD, 10));
        b.addActionListener(this);
        p2.add(b);
        p3.setLayout(new GridLayout(2,1,5,20));
        p3.add(p1);
        p3.add(p2);
        setLayout(new FlowLayout());
        add(p3);
        setBackground(Color.pink);
        setSize(200, 200);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b) {
            setVisible(false);
        }
    }
}
