package domaine;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Souvenir extends Experience{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Souvenir() {
		// TODO Auto-generated constructor stub
	}
	
	public Souvenir(String titre, String description,
			Date dateAjout) {
		super(titre, description, dateAjout);
	}
}
