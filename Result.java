package sql;
import java.awt.*;
import java.awt.event.*;
public class Result extends Frame {
    Label lb, l, l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    Panel p1, p2, p3;
    int mark, attempt;
    boolean b = true;
    char c;
    String status = "", timing = "", min = "", sec = "";
    Frame f;

    Result() {
        f = new Frame();
        f.setTitle("Examination Result");
        mark = Exam.marks;
        attempt = Exam.attempt;
        timing = Exam.timing;
        if (mark > 3) {
            status = "PASS";
        } else {
            status = "FAIL";
        }
        for (int i = 0; i < timing.length(); i++) {
            if ((c = timing.charAt(i)) == ':') {
                b = false;
                continue;
            }
            if (b) {
                min += c;
            } else {
                sec += c;
            }
        }
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        lb = new Label("Interface Exam Simulator");
        lb.setBackground(Color.red);
        lb.setForeground(Color.white);
        lb.setFont(new Font("Arial", Font.BOLD, 25));
        p1.setBackground(Color.red);
        p1.add(lb);
        l = new Label("Result");
        l.setBackground(Color.white);
        l.setForeground(Color.blue);
        l.setFont(new Font("Arial", Font.BOLD, 15));
        l0 = new Label(status);
        l0.setBackground(Color.white);
        l0.setForeground(Color.red);
        l0.setFont(new Font("Arial", Font.BOLD, 15));
        l1 = new Label("Your Score");
        l1.setBackground(Color.white);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l2 = new Label(Integer.toString(mark * 5));
        l2.setBackground(Color.white);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l3 = new Label("Maximum Score");
        l3.setBackground(Color.white);
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        l4 = new Label("50");
        l4.setBackground(Color.white);
        l4.setForeground(Color.red);
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        l5 = new Label("Questions Attempted");
        l5.setBackground(Color.white);
        l5.setForeground(Color.blue);
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        l6 = new Label(Integer.toString(attempt));
        l6.setBackground(Color.white);
        l6.setForeground(Color.red);
        l6.setFont(new Font("Arial", Font.BOLD, 15));
        l7 = new Label("Correct");
        l7.setBackground(Color.white);
        l7.setForeground(Color.blue);
        l7.setFont(new Font("Arial", Font.BOLD, 15));
        l8 = new Label(Integer.toString(mark));
        l8.setBackground(Color.white);
        l8.setForeground(Color.red);
        l8.setFont(new Font("Arial", Font.BOLD, 15));
        l9 = new Label("Wrong");
        l9.setBackground(Color.white);
        l9.setForeground(Color.blue);
        l9.setFont(new Font("Arial", Font.BOLD, 15));
        l10 = new Label(Integer.toString(10 - mark));
        l10.setBackground(Color.white);
        l10.setForeground(Color.red);
        l10.setFont(new Font("Arial", Font.BOLD, 15));
        l11 = new Label("Time Taken");
        l11.setBackground(Color.white);
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Arial", Font.BOLD, 15));
        l12 = new Label(min + " min " + sec + " sec");
        l12.setBackground(Color.white);
        l12.setForeground(Color.red);
        l12.setFont(new Font("Arial", Font.BOLD, 15));
        p2.setLayout(new GridLayout(7, 2, 10, 5));
        p2.add(l);
        p2.add(l0);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(l6);
        p2.add(l7);
        p2.add(l8);
        p2.add(l9);
        p2.add(l10);
        p2.add(l11);
        p2.add(l12);
        f.setBackground(Color.white);
        f.setLayout(new FlowLayout());
        p3.setLayout(new BorderLayout());
        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2);
        f.add(p3);
        f.addWindowListener(new W());
        f.setVisible(true);
        f.setSize(400, 400);
    }

    class W extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
}