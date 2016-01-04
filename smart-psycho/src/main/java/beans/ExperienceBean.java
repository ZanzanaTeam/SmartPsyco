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
import domaine.Reve;
import domaine.Souvenir;

@ManagedBean
public class ExperienceBean {

	private String titre;
	private String description;
	private Date dateAjout;
	private String type;
	
	private List<Experience> experiences;

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
		return "experiance_liste?faces-redirect=true";
	}
	
	public String setVisibility(Integer id){
		experienceServicesLocal.updateVisible(id);
		return "";
	}
	
	public String myExerience(){
		Patient patient = (Patient) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		
		setExperiences(experienceServicesLocal.findByPatient(patient.getId()));
		return "experience_me";
	}
	
	public String AllExperience(){
		setExperiences(experienceServicesLocal.findAll());
		return "experience_liste";
	}
	
	public String setAddExperience(){
		titre = "";
		description = "";
		type ="";
		return "experience_add?faces-redirect=true";
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
		Patient patient = (Patient) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("user");
		
		setExperiences(experienceServicesLocal.findByPatient(patient.getId()));
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

}