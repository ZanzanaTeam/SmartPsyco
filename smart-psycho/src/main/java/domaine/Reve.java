package domaine;

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

	public Reve(String titre, String description) {
		super(titre, description);
	}

}
