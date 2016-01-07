package domaine;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Experience implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titre;
	private String description;
	private Date dateAjout;
	private Boolean visible;

	private Patient patient;
	private List<Media> medias;

	public Experience() {
		// TODO Auto-generated constructor stub
	}

	public Experience(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateAjout = new Date();
		this.visible = false;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", titre=" + titre + ", description="
				+ description + ", dateAjout=" + dateAjout + "]";
	}
	
	public String findType(){
		if(this instanceof Avanture)return "Aventure";
		if(this instanceof Reve)return "Rêve";
		if(this instanceof Souvenir)return "Souvenir";
		return "";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@ManyToOne
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@OneToMany(mappedBy = "experience")
	public List<Media> getMedias() {
		return medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
