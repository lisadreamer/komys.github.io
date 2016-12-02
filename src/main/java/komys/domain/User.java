package komys.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Username with unique constraint
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "firstname", nullable = false)
    private String firstname;    
    
	@Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "db", nullable = false)
    private Date db;
    
    @Column(name = "password", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    private String role;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;

	public User() {
    }

	public User(String username, String firstname, String lastname, String passwordHash, String role, String email, String gender, Date db) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passwordHash = passwordHash;
		this.role = role;
		this.email = email;
		this.gender = gender;
		this.db = db;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDb() {
		return db;
	}

	public void setDb(Date db) {
		this.db = db;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}