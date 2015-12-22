package services.interfaces;

import javax.ejb.Local;

import domaine.Patient;
import services.interfaces.basic.ICrud;

@Local
public interface PatientServicesLocal extends ICrud<Patient>{

	Patient findPatientByLoginPassword(String login , String password);
	Boolean findPatientByLogin(String login);
}
