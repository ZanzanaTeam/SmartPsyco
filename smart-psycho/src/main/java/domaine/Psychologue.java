package domaine;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Psychologue extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address;
	private String phone;
	private String email;

	public Psychologue() {
		// TODO Auto-generated constructor stub
	}

	public Psychologue(String fullName, String login, String password,
			String description, String address, String phone, String email) {
		super(login, password, fullName, description);
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
