package luong.restapi_JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "age")
	public int age;
	
	@Column(name = "email")
	public String email;
	

	customer(int id, String name, int age, String email){
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;		
	}
	customer(){			
	}
	int setid(int id) {
		this.id = id;
		return this.id;
		}
	String setname(String name) {
		 this.name = name;
		 return this.name;
		 }
	int setage(int age) {
		this.age = age;
		return this.age;
		}
	String setemail(String email) {
		this.email = email;
		return this.email;
		}
	
	int getid() {return this.id;}	
	String getname() {return this.name;}
	int getage() {return this.age;}
	String getemail() {return this.email;}	
	
	

}
