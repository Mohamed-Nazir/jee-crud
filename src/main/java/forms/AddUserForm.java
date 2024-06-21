package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UserDaoImpl;

public class AddUserForm extends Utilities{
	
	
	private Utilisateur user;
	private Map<String,String> erreurs;

	private UserDaoImpl userdaoimpl = new UserDaoImpl();
	
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_USERNAME = "username";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordbis";
	
	private boolean status;
	private String statusMessage;
	
	
	public AddUserForm(HttpServletRequest request) {
		super(request);
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean ajouter() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String username =getParameter(CHAMP_USERNAME);
		String password = getParameter(CHAMP_PASSWORD);
		String passwordbis = getParameter(CHAMP_PASSWORD_BIS);
		
		user = new Utilisateur(nom,prenom,username,passwordbis);
		
		validerChamps(erreurs,CHAMP_NOM,CHAMP_PRENOM,CHAMP_USERNAME,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		validerPasswords(erreurs,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		
		if(erreurs.isEmpty()) {
			userdaoimpl.add(user);
			status = true;
			statusMessage= "Utilisateur ajouté avec succes";
		}else {
			status = false;
			statusMessage= "Echec!!";
		}
		return status;
		
	}
	

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public boolean getStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	
	
}

