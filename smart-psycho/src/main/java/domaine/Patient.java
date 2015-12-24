package domaine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Patient extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dateNaissance;
	private Date dateInscription;

	private List<Experience> experiences;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String fullName, String login, String password,
			String description, Date dateNaissance) {
		super(login,password,fullName,description);
		this.dateNaissance = dateNaissance;
		dateInscription = new Date();
	}

	@Override
	public String toString() {
		return "Patient [dateNaissance=" + dateNaissance + ", dateInscription="
				+ dateInscription + ", experiences=" + experiences + "]";
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@OneToMany(mappedBy = "patient")
	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

}
