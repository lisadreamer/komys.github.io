package komys;

import java.util.Date;

import javax.persistence.EntityManager;

import komys.domain.Item;
import komys.domain.ItemRepository;
import komys.domain.MaterialRepository;
import komys.domain.TypeRepository;
import komys.domain.Type;
import komys.domain.Material;
import komys.domain.User;
import komys.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebshopkomysApplication {

	private static final Logger log = LoggerFactory.getLogger(WebshopkomysApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WebshopkomysApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner komys(TypeRepository trep, MaterialRepository mrep, ItemRepository irep, UserRepository urep) {
		return (args) -> {
			log.info("save a types and materials");
			System.out.println(EntityManager.class.getProtectionDomain().getCodeSource().getLocation());
			//adding some types
			trep.save(new Type("Earrings"));
			trep.save(new Type("Rings"));
			trep.save(new Type("Pendant"));
			trep.save(new Type("Bracelet"));
			
			//adding some materials
			mrep.save(new Material("Silver"));
			mrep.save(new Material("Gold"));
			
			//adding some items
			irep.save(new Item("silver earring 01", "images/earrings1.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 9.39,  "-", 49));
			irep.save(new Item("silver earring 02", "images/earrings2.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 7.83,  "-", 59));
			irep.save(new Item("silver earring 03", "images/earrings3.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 10.00, "-", 69));
			irep.save(new Item("silver earring 04", "images/earrings4.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 13.97, "-", 79));
			irep.save(new Item("silver earring 05", "images/earrings5.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 14.28, "-", 79));
			irep.save(new Item("silver earring 06", "images/earrings6.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 8.74,  "-", 49));
			
			irep.save(new Item("silver earring 10", "images/earrings10.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 3.21,  "-", 25));
			irep.save(new Item("silver earring 11", "images/earrings11.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 15.68, "-", 75));
			irep.save(new Item("silver earring 12", "images/earrings12.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 9.14,  "-", 59));
			irep.save(new Item("silver earring 13", "images/earrings13.jpg", trep.findByName("Earrings").get(0),  mrep.findByName("Silver").get(0), 12.89, "-", 69));
			
			//irep.save(new Item("silver ring 01", "images/ring1.jpg", trep.findByName("Rings").get(0),  mrep.findByName("Silver").get(0), 5.46, "-", 29));
			//irep.save(new Item("silver ring 02", "images/ring2.jpg", trep.findByName("Rings").get(0),  mrep.findByName("Silver").get(0), 3.88, "-", 19));
			//irep.save(new Item("silver ring 03", "images/ring3.jpg", trep.findByName("Rings").get(0),  mrep.findByName("Silver").get(0), 4.72, "-", 25));
			irep.save(new Item("silver ring 04", "images/ring4.jpg", trep.findByName("Rings").get(0),  mrep.findByName("Silver").get(0), 3.01, "-", 25));
			
			irep.save(new Item("silver pendant 01", "images/pendant1.jpg", trep.findByName("Pendant").get(0),  mrep.findByName("Silver").get(0), 5.46, "-", 29));
			irep.save(new Item("silver pendant 02", "images/pendant2.jpg", trep.findByName("Pendant").get(0),  mrep.findByName("Silver").get(0), 3.88, "-", 19));
			irep.save(new Item("silver pendant 03", "images/pendant3.jpg", trep.findByName("Pendant").get(0),  mrep.findByName("Silver").get(0), 4.72, "-", 25));
			irep.save(new Item("silver pendant 04", "images/pendant4.jpg", trep.findByName("Pendant").get(0),  mrep.findByName("Silver").get(0), 4.72, "-", 25));
			irep.save(new Item("silver pendant 05", "images/pendant5.jpg", trep.findByName("Pendant").get(0),  mrep.findByName("Silver").get(0), 4.72, "-", 25));
			
			irep.save(new Item("silver bracelet 01", "images/bracelet1.jpg", trep.findByName("Bracelet").get(0),  mrep.findByName("Silver").get(0), 8.31, "-", 49));
			
			// Create users: admin/admin user/user
			Date db = new Date();
						
			User admin = new User("admin", "admin", "admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@gmail.com", "M.", db);
			
			urep.save(admin);
		};
	};
}	
	
