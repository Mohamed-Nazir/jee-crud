package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.Utilisateur;
import db.DatabaseConnector;

public class UserDaoImpl implements UserDao {
    private Connection con;

    public UserDaoImpl() {
    	this.con = DatabaseConnector.getConnection();
        if (this.con == null) {
            throw new RuntimeException("Failed to get database connection");
        }
    }

  
	@Override
    public ArrayList<Utilisateur> getAll() {
        ArrayList<Utilisateur> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Utilisateur user = new Utilisateur(id, nom, prenom, username, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Utilisateur get(int id) {
        Utilisateur user = null;
        try {
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new Utilisateur(id, nom, prenom, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Utilisateur getByUsername(String username) {
        Utilisateur user = null;
        try {
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String password = rs.getString("password");
                user = new Utilisateur(id, nom, prenom, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void add(Utilisateur user) {
        try {
            String sql = "INSERT INTO users (prenom, nom, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getPrenom());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Utilisateur user) {
        try {
            String sql = "UPDATE users SET prenom=?, nom=?, username=?, password=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getPrenom());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
