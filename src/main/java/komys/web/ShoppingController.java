package komys.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import komys.domain.ItemRepository;
import komys.domain.ShoppingItem;
import komys.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingController {	
	
	 
		@Autowired
	    private UserRepository urep; 
		@Autowired
	    private ItemRepository irep;
		
		@Autowired
	    private HttpSession session;
		
		@RequestMapping(value="/cart")
	    public String shoppingcart(Model model) {
	  		System.out.println("Here");
	  		model.addAttribute("cart", session.getAttribute("cart"));
	        return "cart";
	      }
		
		@RequestMapping(value="/ordernow/{id}", method = RequestMethod.GET)
	    public String ordernow(@PathVariable(value="id") Long id, Model model) {
			
			if(session.getAttribute("cart")==null) {
				List<ShoppingItem> cart = new ArrayList<ShoppingItem>();
				ShoppingItem sh = new ShoppingItem(irep.findOne(id),1);				
				cart.add(sh);
				session.setAttribute("cart", cart);
			
			} else{
				List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute("cart");
				int index = isExisting(id);
				if (index == -1){
					ShoppingItem sh = new ShoppingItem(irep.findOne(id),1);				
					cart.add(sh);
				}else{
					int quantity = cart.get(index).getQuantity() + 1;
					cart.get(index).setQuantity(quantity);
				}
				
				session.setAttribute("cart", cart);				
			}
			return "redirect:../cart";
	    }
		
		private int isExisting(Long id){
			List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute("cart");
			for(int i=0;i<cart.size();i++){
				if(cart.get(i).getX().getId() == id){
					return i;
				}								
			}
			return -1;
		}
		
		@RequestMapping(value="/deletecartitem/{id}", method = RequestMethod.GET)
	    public String deletecartitem(@PathVariable(value="id") Long id, Model model) {
							
				List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute("cart");
				int index = isExisting(id);				
				cart.remove(index);
				session.setAttribute("cart", cart);
							
				return "redirect:../cart";
	    }
		
}		
	    
	    

