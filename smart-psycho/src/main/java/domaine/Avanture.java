package domaine;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Avanture extends Experience {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Avanture() {
		// TODO Auto-generated constructor stub
	}
	
	public Avanture(String titre, String description,
			Date dateAjout) {
		super(titre, description, dateAjout);
	}

}
