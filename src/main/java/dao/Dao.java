package dao;

import java.util.ArrayList;


public interface Dao<Utilisateur> {
    
    ArrayList<Utilisateur> listUsers();
    
    void addUser(Utilisateur u);
    
    Utilisateur findUser(int id);
    
    Utilisateur findUser(String username);
    
    void remove(int id);
    
    void update (int id,Utilisateur u);
    
    Utilisateur login (String username, String password);
}