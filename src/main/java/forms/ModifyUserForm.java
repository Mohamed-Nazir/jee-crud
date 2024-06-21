package forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UserDaoImpl;

public class ModifyUserForm extends Utilities{
	
	
	private Utilisateur user;
	private Map<String,String> erreurs;
	
	private UserDaoImpl userdaoimpl = new UserDaoImpl();
	
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_USERNAME = "username";
	private static final String CHAMP_PASSWORD = "password";
	
	private boolean status;
	private String statusMessage;
	
	
	public ModifyUserForm(HttpServletRequest request) {
		super(request);
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean modifier(int id) {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String username =getParameter(CHAMP_USERNAME);
		String password = getParameter(CHAMP_PASSWORD);
		
		user = new Utilisateur(nom,prenom,username,password);
		
		validerChamps(erreurs,CHAMP_NOM,CHAMP_PRENOM,CHAMP_USERNAME,CHAMP_PASSWORD);
		try {
			if(erreurs.isEmpty()) {
				userdaoimpl.update(id,user);
				status = true;
				statusMessage= "Utilisateur modifié avec succes";
			}else {
				status = false;
				statusMessage= "Echec!!";
			}
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
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

