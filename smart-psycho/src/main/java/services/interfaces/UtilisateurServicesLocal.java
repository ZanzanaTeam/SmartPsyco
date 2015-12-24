package services.interfaces;

import javax.ejb.Local;

import services.interfaces.basic.ICrud;
import domaine.Utilisateur;

@Local
public interface UtilisateurServicesLocal extends ICrud<Utilisateur> {

	Utilisateur findByLoginPassword(String login, String password);

	Boolean findPatientByLogin(String login);
}
