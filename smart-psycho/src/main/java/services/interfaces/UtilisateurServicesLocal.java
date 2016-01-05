package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import services.interfaces.basic.ICrud;
import domaine.Psychologue;
import domaine.Utilisateur;

@Local
public interface UtilisateurServicesLocal extends ICrud<Utilisateur> {

	Utilisateur findByLoginPassword(String login, String password);

	Boolean findPatientByLogin(String login);
	
	List<Psychologue> findAllPsy();
}
