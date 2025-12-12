import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBills extends JFrame {
    JTable table;

    public ViewBills() {
        setTitle("All Bills");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"Customer ID", "Name", "Type", "Units", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table));

        for (Bill b : MainMenu.bills) {
            model.addRow(new Object[]{
                b.getCustomerId(),
                b.getName(),
                b.getType(),
                b.getUnits(),
                b.getAmount()
            });
        }

        setVisible(true);
    }
}