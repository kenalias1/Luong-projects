package luong.restapi_JPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customer_jpa_service {
	@Autowired
	private customer_jpa_repository customer_repository;
	
	
	public void customerDB_ini () {		
		   add("Luong", 32, "luong@email.com");	
	       add("Justin", 26, "justin@email.com");
	       add("Tommy", 24, "tommy@email.com");
	       add("Mario", 24, "mario@email.com");	       	       	
	       add("Linda", 22, "linda@email.com");	       
	       add("Anthonio", 24, "anthonio@email.com");	       
	}  	
	 public
	 int add(String name, int age, String email) {
		 customer customer_1 = new customer();
		 customer_1.setname(name);
		 customer_1.setage(age);
		 customer_1.setemail(email);
		 customer_repository.save(customer_1);
		 return customer_repository.findByName(name).id;		 
		
		}
	 public	
	 int update(int id, String name, int age, String email) {
		 customer customer_1 = new customer(id, name, age, email);	
		 customer_repository.save(customer_1);
			return 1;
	}
	 
	 int delete (int id) {
		  customer_repository.deleteById(id);		 
		 
				return 1;
		}	
	 
	 public
		customer read(int id) {
	       return customer_repository.findById(id).get();
		 }	
	 
		public	
		List<customer> readAll() {		
			return customer_repository.findAll();			
		}
	 
}
