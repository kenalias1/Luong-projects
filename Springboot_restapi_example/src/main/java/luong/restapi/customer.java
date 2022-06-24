package luong.restapi;


public class customer {
	public int id;
	public String name;
	public int age;
	public String email;
	
	customer(int id, String name, int age, String email){
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;		
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
