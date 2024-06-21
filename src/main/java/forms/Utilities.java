package forms;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class Utilities {
	
	private static HttpServletRequest req;
	
	private static final String MESSAGE_ERROR_FIELD = "Champ obligatoire";
	private static final String INVALIDE_PASSWORD_ERROR_MESSAGE = "Mots de passe non identiques";
	
	
	public Utilities(HttpServletRequest request) {
		req = request;
	}

	public static String getParameter(String params) {
		String valeur = req.getParameter(params);
		return (valeur ==null || valeur.trim().isEmpty()) ? null : valeur.trim();
	}
	
	public static void validerChamps(Map<String,String> erreurs, String... params ) {
		for(String param : params) {
			if(getParameter(param) == null){
				erreurs.put(param,MESSAGE_ERROR_FIELD);
			}
		}
	}
	
	public static void validerPasswords(Map<String,String> erreurs,String CHAMP_PASSWORD,String CHAMP_PASSWORD_BIS) {
		String password = getParameter(CHAMP_PASSWORD);
		String passwordbis = getParameter(CHAMP_PASSWORD_BIS);
		
		if(password!=null && !password.equals(passwordbis)) {
			erreurs.put(CHAMP_PASSWORD,INVALIDE_PASSWORD_ERROR_MESSAGE);
			erreurs.put(CHAMP_PASSWORD_BIS,INVALIDE_PASSWORD_ERROR_MESSAGE);

		}
	}
	
}
