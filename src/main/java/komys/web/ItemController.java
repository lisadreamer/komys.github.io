package komys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import komys.domain.Item;
import komys.domain.TypeRepository;
import komys.domain.MaterialRepository;
import komys.domain.ItemRepository;


@Controller
public class ItemController {
	
	@Autowired
	private TypeRepository trep;
	@Autowired
	private MaterialRepository mrep;
	@Autowired
	private ItemRepository irep;
		
	@RequestMapping(value="/")
    public String firstr() {	
        return "index";
    }	
	
	@RequestMapping(value="/index")
    public String Index() {	        
        return "index";
    }
	
	@RequestMapping(value="/lookbook")
    public String lookbook() {	        
        return "lookbook";
    }
	
	@RequestMapping(value="/contacts")
    public String contacts() {	        
        return "contacts";
    }
	
	@RequestMapping(value="/products")
    public String ItemList(Model model) {	
        model.addAttribute("items", irep.findAll());
        return "products";
    }
	
	@RequestMapping(value="/products1")
    public String ItemList1(Model model) {	
        model.addAttribute("items", irep.findByType(trep.findByName("Earrings").get(0)));
        return "products";
    }
	
	@RequestMapping(value="/products2")
    public String ItemList2(Model model) {	
        model.addAttribute("items", irep.findByType(trep.findByName("Rings").get(0)));
        return "products";
    }
	
	@RequestMapping(value="/products3")
    public String ItemList3(Model model) {	
        model.addAttribute("items", irep.findByType(trep.findByName("Pendant").get(0)));
        return "products";
    }
	
	@RequestMapping(value="/products4")
    public String ItemList4(Model model) {	
        model.addAttribute("items", irep.findByType(trep.findByName("Bracelet").get(0)));
        return "products";
    }
	
	// RESTful service to get all items
    @RequestMapping(value="/items")
    public @ResponseBody List<Item> itemListRest() {	
        return (List<Item>) irep.findAll();
    } 
		
	//for admin only
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/additem")
    public String addItem(Model model){
    	model.addAttribute("item", new Item());
    	model.addAttribute("types", trep.findAll());
    	model.addAttribute("materials", mrep.findAll());
    	
    	return "additem";
    } 
	
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Item item){
        irep.save(item);
        return "redirect:products";
    }
}
