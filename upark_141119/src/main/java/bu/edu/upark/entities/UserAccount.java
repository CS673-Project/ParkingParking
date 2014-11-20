package bu.edu.upark.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;







@Entity(name="UserAccount")
@Table(name="UserAccount")
public class UserAccount {
	
//	@Id
//	@Column(name="ID", length=32, unique = true)
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid",strategy="uuid")
//	private String id;
	
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	
    
	
    
    
    
    
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	
	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	@Column(name="firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name="lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
