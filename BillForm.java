import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillForm extends JFrame implements ActionListener {
    JTextField tfID, tfName, tfUnits;
    JComboBox<String> cbType;
    JButton btnCalculate, btnSave, btnClear;
    JTextArea taResult;

    public BillForm() {
        setTitle("Electricity Bill Entry");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblID = new JLabel("Customer ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblType = new JLabel("Connection Type:");
        JLabel lblUnits = new JLabel("Units Consumed:");

        tfID = new JTextField();
        tfName = new JTextField();
        cbType = new JComboBox<>(new String[]{"Domestic", "Commercial"});
        tfUnits = new JTextField();

        btnCalculate = new JButton("Calculate");
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        taResult = new JTextArea(5, 20);
        taResult.setEditable(false);

        panel.add(lblID); panel.add(tfID);
        panel.add(lblName); panel.add(tfName);
        panel.add(lblType); panel.add(cbType);
        panel.add(lblUnits); panel.add(tfUnits);
        panel.add(btnCalculate); panel.add(btnSave);
        panel.add(btnClear); panel.add(new JLabel());
        panel.add(new JLabel("Result:")); panel.add(new JScrollPane(taResult));

        add(panel);

        btnCalculate.addActionListener(this);
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);

        setVisible(true);
    }

    double calculateBill(String type, int units) {
        double amt = 0;
        if (type.equals("Domestic")) {
            if (units <= 100)
                amt = units * 1.5;
            else if (units <= 300)
                amt = 100 * 1.5 + (units - 100) * 2.5;
            else
                amt = 100 * 1.5 + 200 * 2.5 + (units - 300) * 4;
        } else {
            if (units <= 100)
                amt = units * 2.5;
            else if (units <= 300)
                amt = 100 * 2.5 + (units - 100) * 4;
            else
                amt = 100 * 2.5 + 200 * 4 + (units - 300) * 6;
        }
        return amt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            try {
                int units = Integer.parseInt(tfUnits.getText());
                String type = (String) cbType.getSelectedItem();
                double bill = calculateBill(type, units);
                taResult.setText("Total Bill: ₹" + bill);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid units entered!");
            }
        } else if (e.getSource() == btnSave) {
            try {
                String id = tfID.getText();
                String name = tfName.getText();
                String type = (String) cbType.getSelectedItem();
                int units = Integer.parseInt(tfUnits.getText());
                double amt = calculateBill(type, units);

                Bill b = new Bill(id, name, type, units, amt);
                MainMenu.bills.add(b);

                JOptionPane.showMessageDialog(this, "Bill saved successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == btnClear) {
            tfID.setText("");
            tfName.setText("");
            tfUnits.setText("");
            taResult.setText("");
        }
    }
}