package komys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import komys.domain.SignupForm;
import komys.domain.User;
import komys.domain.UserRepository;
import komys.domain.ItemRepository;

@Controller
public class UserController {
	
	@Autowired
    private UserRepository repository; 
	@Autowired
    private ItemRepository irep;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	 
    @RequestMapping(value = "signup")
    public String addUser(Model model){
    	model.addAttribute("signupform", new SignupForm());
    	System.out.println("sign up");
        return "signup";
    }	
  	
    /**
     * Create new user
     * Check if user already exists & form validation
     * 
     * @param signupForm
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    	
    	System.out.println("sign up save");
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
	    		String pwd = signupForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupForm.getUsername());
		    	newUser.setFirstname(signupForm.getFirstname());
		    	newUser.setLastname(signupForm.getLastname());
		    	newUser.setGender(signupForm.getGender());
		    	newUser.setDb(signupForm.getDb());
		    	newUser.setRole("USER");
		    	newUser.setEmail(signupForm.getEmail());
		    	if (repository.findByUsername(signupForm.getUsername()) == null) { // Check if user exists
		    		repository.save(newUser);		    		
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists"); 	    				    			
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    			    			
    			return "signup";
    		}
    	}
    	else {
    		System.out.println("sign up errors"+bindingResult.getAllErrors());
    		return "signup";
    	}
    	
    	return "redirect:/login";    	
    }    
    
    //for only admin view
    @PreAuthorize("hasAuthority('ADMIN')")
  	@RequestMapping(value="/showu")
      public String showu(Model model) {	
  		model.addAttribute("users", repository.findAll());
          return "usrs";
      }
}
