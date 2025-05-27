import javax.swing.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {

    private JTextField tfUsername, tfEmail, tfPhone, tfDob;
    private JPasswordField pfPassword;
    private JButton btnRegister;

    public RegistrationForm() {
        setTitle("Restaurant Registration");
        setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // UI Components
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 100, 25);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(120, 20, 180, 25);
        add(tfUsername);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 60, 100, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(120, 60, 180, 25);
        add(tfEmail);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(20, 100, 100, 25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(120, 100, 180, 25);
        add(tfPhone);

        JLabel lblDob = new JLabel("DOB (yyyy-mm-dd):");
        lblDob.setBounds(20, 140, 150, 25);
        add(lblDob);

        tfDob = new JTextField();
        tfDob.setBounds(160, 140, 140, 25);
        add(tfDob);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 180, 100, 25);
        add(lblPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(120, 180, 180, 25);
        add(pfPassword);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(100, 220, 120, 30);
        add(btnRegister);

        btnRegister.addActionListener(e -> registerUser());
        setVisible(true);
    }

    private void registerUser() {
        String username = tfUsername.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String dob = tfDob.getText();
        String password = new String(pfPassword.getPassword());

        if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || dob.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return;
        }

        if (!phone.matches("^\\d{10}$")) {
            JOptionPane.showMessageDialog(this, "Phone must be 10 digits.");
            return;
        }

        User user = new User(username, email, phone, dob, password);
        if (Database.saveUser(user)) {
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed.");
        }
    }
}
