package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.interfaces.UtilisateurServicesLocal;
import domaine.Patient;
import domaine.Psychologue;
import domaine.Utilisateur;

@ManagedBean
@SessionScoped
public class UtilisateurBeans {

	private Integer id;
	private String fullName;
	private Date dateNaissance;
	private String description;
	private String login;
	private String password;
	private String address;
	private String phone;
	private String email;
	
	private List<Psychologue> psychologues;

	@EJB
	UtilisateurServicesLocal patientServicesLocal;

	public String inscriptionPatient() {
		Utilisateur utilisateur = new Patient(fullName, login, password,
				description, dateNaissance);
		if (!patientServicesLocal.findPatientByLogin(login)) {

			if (patientServicesLocal.add(utilisateur)) {

				return "login?faces-redirect=true";
			}
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Login existe deja"));

		return "";
	}

	public String inscriptionPsycho() {
		Utilisateur utilisateur = new Psychologue(fullName, login, password,
				description, address, phone, email);
		if (!patientServicesLocal.findPatientByLogin(login)) {

			if (patientServicesLocal.add(utilisateur)) {
				return "login?faces-redirect=true";
			}
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Login existe deja"));

		return "";
	}

	public String authentification() {
		Utilisateur utilisateur = patientServicesLocal.findByLoginPassword(
				login, password);

		if (utilisateur != null) {
			id = utilisateur.getId();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("user", utilisateur);
			if (utilisateur instanceof Patient)
				return "patient/principale?faces-redirect=true";
			if (utilisateur instanceof Psychologue)
				return "psycho/principale?faces-redirect=true";
		}
		login = null;
		password = null;
		return "inscription?faces-redirect=true";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();

		return "../index?faces-redirect=true";
	}

	public String setUpdateProfil() {

		Utilisateur utilisateur = (Utilisateur) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("user");
		id = utilisateur.getId();
		utilisateur = patientServicesLocal.findById(id);

		fullName = utilisateur.getFullName();
		login = utilisateur.getLogin();
		password = utilisateur.getPassword();
		description = utilisateur.getDescription();

		if (utilisateur instanceof Patient) {

			Patient patient = (Patient) utilisateur;
			dateNaissance = patient.getDateNaissance();
		} else {
			Psychologue psychologue = (Psychologue) utilisateur;
			address = psychologue.getAddress();
			phone = psychologue.getPhone();
			email = psychologue.getEmail();
		}
		return "modifier_profil";
	}

	public String updateProfil() {

		Utilisateur utilisateur = (Utilisateur) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("user");

		if (utilisateur instanceof Patient) {

			Patient patient = new Patient(fullName, login, password,
					description, dateNaissance);
			patient.setId(id);
			patientServicesLocal.update(patient);
		} else {
			Psychologue psychologue = new Psychologue(fullName, login,
					password, description, address, phone, email);
			psychologue.setId(id);
			patientServicesLocal.update(psychologue);
		}
		return "principale";
	}
	
	public String psyListe(){
		return "psy_liste";
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

	public Integer getId() {

		Utilisateur utilisateur = (Utilisateur) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("user");
		if (utilisateur != null)
			id = utilisateur.getId();
		else
			id = 0;

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Psychologue> getPsychologues() {
		psychologues = patientServicesLocal.findAllPsy();
		return psychologues;
	}

}
