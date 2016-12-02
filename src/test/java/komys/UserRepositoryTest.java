package komys;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import komys.domain.User;
import komys.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository urep;
	
	@Test
    public void createNewUser() {
		Date b= null;
		String a="01-08-1985";
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");		
		try{ b = (Date)df.parse(a); }
        catch(ParseException e){     
        }
        
		java.sql.Date db = new java.sql.Date(b.getTime());
			
		User user = new User("accountant","Helen","Forss", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "accountant@gmail.com", "Ms.", db);
    	urep.save(user);
    	assertThat(user.getId()).isNotNull();
    	assertThat(user.getRole()).isEqualTo("USER");
    }
	
	@Test
    public void findByUsernameShouldReturnUser() {
        User user = urep.findByUsername("admin");
        
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getUsername()).doesNotContain("{");
        assertThat(user.getGender()).isIn("M.","Ms.");        
    }
	
	@Test
    public void deleteUser() {
		
		Date db = new Date();
		User user = new User("user9","Robert","Forss", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user9@gmail.com", "M.", db);
    	urep.save(user);
    	assertThat(user.getId()).isNotNull();
    	
    	//test delete functionality for the user9 we just created
    	Long userid = user.getId();
    	urep.delete(userid);
    	User u = urep.findOne(userid);
    	assertThat(u).isNull();
    } 
}
