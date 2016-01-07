package beans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import services.interfaces.ExperienceServicesLocal;
import domaine.Avanture;
import domaine.Experience;
import domaine.Patient;
import domaine.Psychologue;
import domaine.Reve;
import domaine.Souvenir;
import domaine.Utilisateur;

@ManagedBean
public class ExperienceBean {

	private String titre;
	private String description;
	private Date dateAjout;
	private String type;

	private List<Experience> experiences;
	private List<Experience> experiencesAll;

	@EJB
	ExperienceServicesLocal experienceServicesLocal;

	public String addExperience() {
		Patient patient = (Patient) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		Experience experience = new Experience();
		if (type.toLowerCase().equals("reve"))
			experience = new Reve(titre, description);
		if (type.toLowerCase().equals("souvenir"))
			experience = new Souvenir(titre, description);
		if (type.toLowerCase().equals("aventure"))
			experience = new Avanture(titre, description);
		experience.setPatient(patient);
		experienceServicesLocal.add(experience);
		return "experience_me";
	}

	public String setVisibility(Integer id) {
		experienceServicesLocal.updateVisible(id);
		return myExerience("Experience");
	}

	public String myExerience(String type) {
		Utilisateur utilisateur = (Utilisateur) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");

		setExperiences(experienceServicesLocal.findByType(type, utilisateur.getId()));
		return "experience_me";
	}

	public String allExperience() {
		setExperiencesAll(experienceServicesLocal.findAll());
		return "experience_liste";
	}

	public String setAddExperience() {
		titre = "";
		description = "";
		type = "";
		return "experience_add?faces-redirect=true";
	}

	private Boolean isPsycho() {
		Utilisateur utilisateur = (Utilisateur) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("user");

		if (utilisateur instanceof Psychologue)
			return true;
		return false;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Experience> getExperiences() {
		Utilisateur utilisateur = (Utilisateur) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");

		setExperiences(experienceServicesLocal.findByType("Experience", utilisateur.getId()));
		
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Experience> getExperiencesAll() {
		setExperiencesAll(experienceServicesLocal.findAll());
		return experiencesAll;
	}

	public void setExperiencesAll(List<Experience> experiencesAll) {
		this.experiencesAll = experiencesAll;
	}

}
