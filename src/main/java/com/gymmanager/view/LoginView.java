package com.gymmanager.view;

public class LoginView package com.example.gymmanager.view;

import com.example.gymmanager.controller.LoginController;
import javax.swing.*;
        import java.awt.*;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;
    private LoginController controller;

    public LoginView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("GymManager - Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Titre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel titleLabel = new JLabel("Connexion GymManager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, gbc);

        // Username
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(new JLabel("Nom d'utilisateur:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(new JLabel("Mot de passe:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Message
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        panel.add(messageLabel, gbc);

        // Bouton
        gbc.gridy = 4;
        loginButton = new JButton("Se connecter");
        loginButton.addActionListener(e -> performLogin());
        panel.add(loginButton, gbc);

        // Enter key support
        getRootPane().setDefaultButton(loginButton);

        add(panel);
    }

    private void performLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (controller != null) {
            controller.handleLogin(username, password);
        }
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public void showError(String message) {
        messageLabel.setForeground(Color.RED);
        messageLabel.setText(message);
    }

    public void showSuccess(String message) {
        messageLabel.setForeground(Color.GREEN);
        messageLabel.setText(message);
    }

    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        messageLabel.setText("");
    }

    public void show() {
        clearFields();
        setVisible(true);
    }

    public void hide() {
        setVisible(false);
    }
}{
}
