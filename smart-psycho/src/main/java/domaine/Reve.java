package domaine;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Reve extends Experience {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Reve() {
		// TODO Auto-generated constructor stub
	}
	
	public Reve(String titre, String description,
			Date dateAjout) {
		super(titre, description, dateAjout);
	}
	
	

}
