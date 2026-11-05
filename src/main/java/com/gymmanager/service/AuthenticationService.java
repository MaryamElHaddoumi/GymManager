package com.gymmanager.service;

import com.example.gymmanager.dao.UserDAO;
import com.example.gymmanager.model.User;
import java.util.Optional;

public class AuthenticationService {
    private UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> authenticate(String username, String password) {
        // Validation basique
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            return Optional.empty();
        }

        return userDAO.authenticate(username, password);
    }

    public boolean registerUser(String username, String password, String role) {
        // Vérifier si l'utilisateur existe déjà
        if (userDAO.findByUsername(username).isPresent()) {
            return false;
        }

        User newUser = new User(username, password, role);
        return userDAO.save(newUser);
    }

    public boolean isAdmin(User user) {
        return user != null && "ADMIN".equals(user.getRole());
    }
}