package beans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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

	@EJB
	PatientServicesLocal patientServicesLocal;

	public String inscription() {

		Patient p = new Patient(fullName, dateNaissance, description, login,
				password);

		if (!patientServicesLocal.findPatientByLogin(login)) {

			if (patientServicesLocal.add(p)) {
				return "login";
			}
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Login existe deja"));
		return "";
	}

	public String authentification() {
		if (patientServicesLocal.findPatientByLoginPassword(login, password)) {
			return "principalePatient";
		}
		return "inscription";
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

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

}
