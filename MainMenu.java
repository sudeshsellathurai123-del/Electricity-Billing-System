import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    JButton btnAddBill, btnViewBills, btnExit;
    static ArrayList<Bill> bills = new ArrayList<>();

    public MainMenu() {
        setTitle("Electricity Billing System - Main Menu");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAddBill = new JButton("Add New Bill");
        btnViewBills = new JButton("View All Bills");
        btnExit = new JButton("Logout");

        btnAddBill.setBounds(120, 60, 150, 40);
        btnViewBills.setBounds(120, 120, 150, 40);
        btnExit.setBounds(120, 180, 150, 40);

        add(btnAddBill); add(btnViewBills); add(btnExit);

        btnAddBill.addActionListener(this);
        btnViewBills.addActionListener(this);
        btnExit.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddBill) {
            new BillForm();
        } else if (e.getSource() == btnViewBills) {
            new ViewBills();
        }
    }
}