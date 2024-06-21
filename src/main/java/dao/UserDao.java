package dao;

import java.util.ArrayList;
import beans.Utilisateur;

public interface UserDao {
    ArrayList<Utilisateur> getAll();
    Utilisateur get(int id);
    Utilisateur getByUsername(String username);
    void add(Utilisateur user);
    void update(int id, Utilisateur user);
    void delete(int id);
}
