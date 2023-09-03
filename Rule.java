package sql;
import java.awt.*;
import java.awt.event.*;
public class Rule extends Frame implements ActionListener {
    Panel p1, p2, p3, p4;
    Button b1;
    Label l0, l1, l2, l3, l4, l5, l6, l7;
    Frame f;

    Rule() {
        f = new Frame();
        f.setTitle("Interface Exam Simulator");
        l1 = new Label("Interface Exam Simulator");
        l1.setBackground(Color.yellow);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l2 = new Label("RULES FOR EXAMINATION");
        l2.setBackground(Color.green);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l3 = new Label("1. The Students are not entitled to take help from any of the outsources at the time of answering the Questions.");
        l3.setFont(new Font("Arial", Font.BOLD, 13));
        l4 = new Label("2. Complete ur respective exam within 30 min otherwise automatically you will be logged out.");
        l4.setFont(new Font("Arial", Font.BOLD, 13));
        l5 = new Label("3. There are total 10 questions in each section carrying 5 marks each. Each question has 4 options. Once you move to next question you can't move back.");
        l5.setFont(new Font("Arial", Font.BOLD, 13));
        l6 = new Label("4. You have to correct minimum 5 questions to clear the exam. No deduction of mark on wrong attempt.");
        l6.setFont(new Font("Arial", Font.BOLD, 13));
        l7 = new Label("5. All the best for your exam.");
        l7.setFont(new Font("Arial", Font.BOLD, 13));
        b1 = new Button("BACK TO USER LOGIN");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.addActionListener(this);
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p1.add(l1);
        p2.setLayout(new GridLayout(6, 1, 5, 15));
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(l6);
        p2.add(l7);
        p3.add(b1);
        p4.setLayout(new GridLayout(3, 1, 10, 20));
        p4.add(p1);
        p4.add(p2);
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            Chapter l = new Chapter();
        }
    }
}

