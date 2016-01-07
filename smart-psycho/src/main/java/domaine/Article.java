package domaine;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titre;
	private String description;
	private Date dateAjout;
	private Boolean visible;
	private Psychologue psychologue;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne
	public Psychologue getPsychologue() {
		return psychologue;
	}



	public void setPsychologue(Psychologue psychologue) {
		this.psychologue = psychologue;
	}



	public Article(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateAjout = new Date();
		this.visible = false;
	
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
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	
}
