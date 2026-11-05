package com.gymmanager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        System.out.println("🔧 LoginController initialisé");

        // Valeurs par défaut pour le test
        usernameField.setText("admin");
        passwordField.setText("admin123");
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("🔐 Tentative de connexion:");
        System.out.println("   Utilisateur: " + username);
        System.out.println("   Mot de passe: " + password);

        if (username.equals("admin") && password.equals("admin123")) {
            messageLabel.setText("✅ Connexion réussie !");
            messageLabel.setStyle("-fx-text-fill: green;");
            System.out.println("🎉 Connexion réussie !");
        } else {
            messageLabel.setText("❌ Identifiants incorrects");
            messageLabel.setStyle("-fx-text-fill: red;");
            System.out.println("❌ Échec de connexion");
        }
    }
}