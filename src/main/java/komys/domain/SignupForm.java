package komys.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class SignupForm {
    @NotEmpty
    @Size(min=5, max=30)
    private String username = "";
    
    @NotEmpty
    @Size(min=2, max=50)    
    private String firstname = "";

    @NotEmpty
    @Size(min=2, max=50)    
    private String lastname = "";

    @NotEmpty
    @Size(min=8, max=30)
    private String password = "";

    @NotEmpty
    @Size(min=8, max=30)
    private String passwordCheck = "";

    @NotEmpty
    private String role = "USER";
    
    @NotEmpty
    private String gender = "";
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date db;

	@NotEmpty
    @Size(min=5, max=30)
    private String email = "";

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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
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

