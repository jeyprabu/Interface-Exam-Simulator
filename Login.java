package sql;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends Frame implements ActionListener {
    Frame f;
    Label l, l1, l2, l3;
    Panel p1, p2, p3, p4;
    TextField tf1, tf2;
    Button b;
    boolean bb = true;
    String name, pass;
    static String nm, msg;
    Validate v;

    Login() {
        f = new Frame();
        f.setTitle("Interface Exam Simulator");
        v = new Validate(f, "Alert", true);
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        l1 = new Label("LOGIN");
        l1.setFont(new Font("Arial", Font.BOLD, 25));
        l1.setForeground(Color.white);
        l2 = new Label("Name");
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l2.setBackground(Color.white);
        l2.setForeground(Color.red);
        l3 = new Label("Password");
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        l3.setBackground(Color.white);
        l3.setForeground(Color.red);
        tf1 = new TextField(20);
        tf1.setFont(new Font("Arial", Font.PLAIN, 20));
        tf1.setBackground(Color.yellow);
        tf1.setForeground(Color.blue);
        tf2 = new TextField(20);
        tf2.setEchoChar('*');
        tf2.setFont(new Font("Arial", Font.PLAIN, 20));
        tf2.setBackground(Color.yellow);
        tf2.setBackground(Color.blue);
        b = new Button("SUBMIT");
        b.addActionListener(this);
        b.setFont(new Font("Arial", Font.BOLD, 20));
        b.setBackground(Color.white);
        b.setForeground(Color.blue);
        p1.setBackground(Color.blue);
        p1.add(l1);
        p2.setLayout(new GridLayout(2, 2));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p3.setBackground(Color.blue);
        p3.add(b);
        p4.setLayout(new GridLayout(3, 1, 5, 20));
        p4.add(p1);
        p4.add(p2);
        p4.add(p3);
        f.setLayout(new FlowLayout());
        f.add(p4);
        f.setVisible(true);
        f.setBackground(Color.cyan);
        f.setSize(1050, 1050);
        f.addWindowListener(new W());
    }

    class W extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            if (s1 == null || s1.isEmpty()) {
                msg = "You can't leave the Name field blank";
                v.check();
                tf1.setText("");
                tf2.setText("");
                v.setVisible(true);
            } else if (s2 == null || s2.isEmpty()) {
                msg = "You can't left the Password field blank";
                v.check();
                tf1.setText("");
                tf2.setText("");
                v.setVisible(true);
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg", "root", "root");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from LOGIN");
                    while (rs.next()) {
                        name = rs.getString("USER_NAME");
                        pass = rs.getString("USER_PASS");
                        nm = name;
                        System.out.println(name + " " + pass);
                        if (s1.equalsIgnoreCase(name) && s2.equalsIgnoreCase(pass)) {
                            if (rs.getString("STATUS").equals("A")) {
                                f.setVisible(false);
                                Admin a = new Admin();
                                System.out.println("Valid Admin");
                            } else {
                                f.setVisible(false);
                                Chapter c = new Chapter();
                                System.out.println("Valid User");
                            }
                        } else {
                            v.check();
                            v.setVisible(true);
                            tf1.setText("");
                            tf1.setText("");
                        }
                    }
                    con.close();
                    st.close();
                } catch (Exception e) {
                    System.out.println("Caught : " + e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Login l = new Login();
    }
}













