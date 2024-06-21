package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDAO implements Dao<Utilisateur> {
	
	private static final ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
	private static int lastId=1;
	static {
		users.add(new Utilisateur("admin","admin","admin","admin"));
	}
	
	
	public void addUser(Utilisateur u) {
		u.setId(lastId++);
		users.add(u);
	}
	
	public ArrayList<Utilisateur> listUsers () {
		return users;
	}
	
	public void remove (int id) {
		for(Utilisateur user : users) {
			if(user.getId() == id) {
				users.remove(user);
				break;
			}
		}
	}
	
	public void update (int id,Utilisateur modifiedUser) {
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getId() == id) {
				modifiedUser.setId(id);
				users.set(i, modifiedUser);
				break;
			}
		}
	}
	
	public Utilisateur findUser (int id) {
		for(Utilisateur user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	
	public Utilisateur findUser (String username) {
		for(Utilisateur user : users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	public Utilisateur login (String username, String password) {
		for(Utilisateur user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
}
