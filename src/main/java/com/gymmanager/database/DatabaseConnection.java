package com.gymmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connexion;

    public static Connection getConnexion() {
        if (connexion == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/gymdb";
                String utilisateur = "root";
                String motDePasse = "";
                connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
                System.out.println("Connexion à MySQL établie avec succès !");
            } catch (SQLException e) {
                System.out.println("Erreur de connexion à MySQL : " + e.getMessage());
            }
        }
        return connexion;
    }

    public static void testerConnexion() {
        try {
            Connection conn = getConnexion();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Base de données : gymdb - Statut : Connecté");
            } else {
                System.out.println("La connexion à la base de données est fermée ou nulle");
            }
        } catch (Exception e) {
            System.out.println("Test échoué : " + e.getMessage());
        }
    }

    public static void fermerConnexion() {
        try {
            if (connexion != null && !connexion.isClosed()) {
                connexion.close();
                connexion = null;
                System.out.println("Connexion fermée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }
    }
}