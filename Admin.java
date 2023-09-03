package sql;
import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.io.*;

public class Admin extends Frame implements ActionListener, ItemListener {
    Panel p0,p1,p2,p3,p4;
    Button b0,b1,b2,b3,b4;
    TextField tf0;
    Label l,l0;
    Frame f;
    Choice chap;
    String s="";
    static String msg;
    ValidateA v;
    Admin () {
        f = new Frame();
        f.setTitle("Interface Exam Simulator");
        v = new ValidateA(f, "Alert", true);
        l = new Label("Choose chapter to Insert Question:-");
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setBackground(Color.black);
        l.setForeground(Color.white);
        l0 = new Label("Create New Chapter :-");
        l0.setFont(new Font("Arial", Font.BOLD, 20));
        l0.setBackground(Color.black);
        l0.setForeground(Color.white);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg", "root", "root");
            Statement st = con.createStatement();
            ResultSet rsl = st.executeQuery("select * from CHAPTER");
            chap = new Choice();
            while (rsl.next()) {
                String cc = rsl.getString("USER_CHAPTER");
                System.out.println(cc);
                chap.addItem(cc);
            }
        } catch (Exception e4) {
            System.out.println("Error : " + e4.getMessage());
        }
        chap.setFont(new Font("Arial", Font.BOLD, 20));
        chap.setBackground(Color.black);
        chap.setForeground(Color.white);
        chap.addItemListener(this);
        b0 = new Button("CREATE");
        b0.setBackground(Color.blue);
        b0.setForeground(Color.white);
        b0.addActionListener(this);
        b1 = new Button("INSERT QUESTION");
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
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.addActionListener(this);
        tf0 = new TextField(20);
        tf0.setBackground(Color.yellow);
        tf0.setForeground(Color.blue);
        tf0.setFont(new Font("Arial", Font.BOLD, 20));
        p0 = new Panel();
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p0.add(l0);
        p0.add(tf0);
        p0.add(b0);
        p1.add(l);
        p1.add(chap);
        p2.setLayout(new GridLayout(4, 1, 25, 10));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p3.add(p2);
        p4.setLayout(new GridLayout(4, 1, 5, 10));
        p4.add(p0);
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
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
    public void itemStateChanged (ItemEvent ie) {
        s=chap.getSelectedItem();
    }
    public void actionPerformed(ActionEvent ae) {
        String chp = s;
        int i = 0;
        int j = 0;
        int p = 0;
        int size1 = 0;
        int k;
        int size2 = 0;
        String s1 = "";
        String s2 = "";
        String[] str = new String[6];
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        if (ae.getSource() == b0) {
            String c = tf0.getText();
            if (c == null || c.isEmpty()) {
                msg = "You can't leave the field blank";
                v.check();
                tf0.setText("");
                v.setVisible(true);
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg", "root", "root");
                    Statement st = con.createStatement();
                    System.out.println("IF not present....");
                    st.executeUpdate("insert into CHAPTER values(chps.nextval,'" + c + "')");
                    st.close();
                    con.close();
                } catch (Exception e5) {
                    System.out.println("Error : " + e5.getMessage());
                }
                tf0.setText("");
                f.setVisible(false);
                Success s = new Success();
            }
        } else if (ae.getSource() == b1) {
            for (i = 1; i <= 10; i++) {
                try {
                    fis1 = new FileInputStream(chp + "/q" + i + ".txt");
                    fis2 = new FileInputStream(chp + "/a" + i + ".txt");
                    size1 = fis1.available();
                    for (j = 0; j < size1; j++) {
                        s1 += (char) fis1.read();
                    }
                    size2 = fis2.available();
                    k = 0;
                    for (j = 0; j < size2; j++) {
                        char c = (char) fis2.read();
                        if (c != '\n') {
                            s2 += c;
                        } else {
                            str[k] = s2;
                            System.out.println("***" + str[k]);
                            k++;
                            s2 = "";
                        }
                    }
                    System.out.println(chp);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg", "root", "root");
                    PreparedStatement ps = con.prepareStatement("insert into " + chp + " values (?,?,?,?,?,?,?)");
                    ps.setInt(1, i);
                    ps.setString(2, s1);
                    for (p = 0; p < 5; p++) {
                        ps.setString(p + 3, str[p]);
                    }
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                    fis1.close();
                    fis2.close();
                    System.out.println(s1 + "\n" + "**********");
                    s1 = "";
                } catch (Exception e) {
                    System.out.println("ERROR:" + e.getMessage());
                }
            }
            f.setVisible(false);
            Success s = new Success();
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
            Login l = new Login();
        } else if (ae.getSource() == b3) {
            f.setVisible(false);
            Home h = new Home();
        } else if (ae.getSource() == b4) {
            f.setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String []args) {
        Admin a = new Admin();
    }
}

