package domaine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String fullName;
	private Date dateNaissance;
	private String description;
	private String login;
	private String password;
	private Date dateInscription;

	private List<Experience> experiences;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String fullName, Date dateNaissance, String description,
			String login, String password) {
		super();
		this.fullName = fullName;
		this.dateNaissance = dateNaissance;
		this.description = description;
		this.login = login;
		this.password = password;
		this.setDateInscription(new Date());
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", fullName=" + fullName
				+ ", dateNaissance=" + dateNaissance + ", description="
				+ description + ", login=" + login + ", password=" + password
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
