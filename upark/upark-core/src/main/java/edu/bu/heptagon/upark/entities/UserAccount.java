package edu.bu.heptagon.upark.entities;

import java.util.UUID;

@Entity(name="UserAccount")
@Table(name="useraccount")
public class UserAccount {
	@Id
	@Column(name="ID", length=32)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
    private UUID id;
	@unique
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
