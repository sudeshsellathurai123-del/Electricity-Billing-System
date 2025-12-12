import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LoginFrame extends JFrame implements ActionListener {
    JTextField tfUser;
    JPasswordField pfPass;
    JButton btnLogin;

    static ArrayList<User> users = new ArrayList<>();

    public LoginFrame() {
        setTitle("Electricity Billing System - Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        users.add(new User("admin", "admin123"));

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");
        tfUser = new JTextField();
        pfPass = new JPasswordField();
        btnLogin = new JButton("Login");

        panel.add(lblUser); panel.add(tfUser);
        panel.add(lblPass); panel.add(pfPass);
        panel.add(new JLabel()); panel.add(btnLogin);
        add(panel);

        btnLogin.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = tfUser.getText();
        String pass = new String(pfPass.getPassword());
        boolean valid = false;

        for (User u : users) {
            if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                valid = true;
                break;
            }
        }

        if (valid) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new MainMenu();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}