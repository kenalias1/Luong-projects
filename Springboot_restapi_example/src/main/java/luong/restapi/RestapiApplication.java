package luong.restapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class RestapiApplication implements ApplicationRunner { 
	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}
	
	 @RequestMapping("/")
    private String listCustomers(Model model){	 	   
		  List<customer> sqllist = customerAPI_i.readAll();
		model.addAttribute("customers", sqllist);
       return "index";       
   	}
	 
	 @GetMapping("/view")	 
	    private String ViewCustomer(@RequestParam int id, Model model){	 	   
			  //customer customer_i = new customer(0, "Sam", 28, "sam@mail.com");
		 customer customer_i = customerAPI_i.read(id) ;
			model.addAttribute("customer", customer_i);	
	       return "view";       
	   	}
	 
	 @GetMapping("/delete")	 
	    private String DeleteCustomer(@RequestParam int id, Model model){	   
	
		 String customer_name = customerAPI_i.read(id).name;
		    customerAPI_i.delete(id) ;	
		    model.addAttribute("customer_name", customer_name);

	       return "delete";       
	   	}
	 
	 @PostMapping("/add")	 
	    private String ViewCustomer(@RequestParam (name = "name") String name,
		    						 @RequestParam (name = "age") int age,
		    						 @RequestParam (name = "email")String email,
		    						 Model model){		   
		 int id = customerAPI_i.add(name, age, email);
		   customer customer_i = customerAPI_i.read(id);
			model.addAttribute("customer", customer_i);	

	       return "add";       
	   	}
	 
	 @GetMapping("/update")	 //return update form
	    private String updateForm(@RequestParam(value = "id",  defaultValue = "0") int id, Model model){
			if (id!=0) {				
				   customer customer_i = customerAPI_i.read(id);
					model.addAttribute("customer", customer_i);	
				return "updateform"; 				
			}
			return "redirect:/";
	   	}
	 
	 @PostMapping("/update")	//processing update form 
	    private String upadateResult(@RequestParam (value = "id") int id,
	    							 @RequestParam (value = "name") String name,
		    						 @RequestParam (value = "age") int age,
		    						 @RequestParam (value = "email")String email,
		    						 Model model){	
		 
		 customerAPI_i.update(id, name, age, email);
		   customer customer_i = customerAPI_i.read(id);
				model.addAttribute("customer", customer_i);	
		       return "updateresult"; 
	 }
   @Override	   
   public void run(ApplicationArguments customerAPI_b) throws Exception {	
	   customerAPI_i.customerDB_ini();	
   }
   public List<customer> sqllist;  
   @Autowired
   public customerAPI customerAPI_i;
	

	
}
