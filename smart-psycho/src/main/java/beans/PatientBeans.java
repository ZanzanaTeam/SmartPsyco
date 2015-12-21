package beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import services.interfaces.PatientServicesLocal;
import domaine.Patient;

@ManagedBean
public class PatientBeans {

	
	private Patient patient;
	
	private String fullName;
	private Date dateNaissance;
	private String description;
	private String login;
	private String password;
	private Date dateInscription;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	@EJB PatientServicesLocal patientServicesLocal;
	
	public String inscription(){
		
		if(patientServicesLocal.add(patient)){
			return "login";
		}
		return "";
	}
	
	public String authentificatin(){
		if(patientServicesLocal.findPatientByLoginPassword(patient.getLogin(), patient.getPassword())){
			return "principalePatient";
		}
		return "";
	}
		
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
