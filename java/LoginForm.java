import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    public JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;

    public LoginForm() {
        // setLayout(new GridLayout(4, 2, 10, 10));
        frame = new JFrame();
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        statusLabel = new JLabel("Status...");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(statusLabel);
        
        usernameLabel.setBounds(50,50,100,20);
        passwordLabel.setBounds(50,100,100,20);
        usernameField.setBounds(150,50,100,20);
        passwordField.setBounds(150,100,100,20);
        loginButton.setBounds(50,150,200,20);
        statusLabel.setBounds(50,200,200,20);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        frame.setTitle("User Login Form");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    private void performLogin() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();//cause it returns the char array
        String password = new String(passwordChars);//char[] is safer way as compare to direct String

        if (username.equals("gauri") && password.equals("ckt")) {
            statusLabel.setText("Login successful!");
        } else {
            statusLabel.setText("Login failed. Please try again.");
        }

        passwordField.setText("");
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
