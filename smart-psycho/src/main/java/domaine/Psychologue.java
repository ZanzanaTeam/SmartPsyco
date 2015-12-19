package domaine;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Psychologue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fullName;
	private String address;
	private String phone;
	private String email;
	private String description;

	public Psychologue() {
		// TODO Auto-generated constructor stub
	}

	public Psychologue(String fullName, String address, String phone,
			String email, String description) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Psychologue [id=" + id + ", fullName=" + fullName
				+ ", address=" + address + ", phone=" + phone + ", email="
				+ email + ", description=" + description + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
