package luong.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class customerAPI {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	public void customerDB_ini () {
		   //jdbcTemplate.execute("DROP DATABASE customerdb IF EXIST");
		  // jdbcTemplate.execute("CREATE DATABASE customerdb");
		  // jdbcTemplate.execute("USE customerdb");	
		   jdbcTemplate.execute("DROP TABLE customer IF EXISTS");
	       jdbcTemplate.execute("CREATE TABLE customer(" +
	                 "id SERIAL, name VARCHAR(255), age NUMERIC(9), email VARCHAR(255))");
	       add("David", 23, "david@email.com");
	       add("Tommy", 24, "tommy@email.com");
	       add("Luong", 32, "luong@email.com");		       	
	       add("Linda", 22, "linda@email.com");
	       add("Anthonio", 24, "anthonio@email.com");	
	       add("Jessisca", 26, "jessisca@email.com");
	}  
	
	 public
	 int add(String name, int age, String email) {
		 String sql = "INSERT INTO customer (name, age, email) VALUES (?,?,?)";
		jdbcTemplate.update(sql, new Object[] {name, age, email});	
		sql = "SELECT id FROM CUSTOMER WHERE name = ?";
		return (int) jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{name});
		}
	 
	 public	
	 int update(int id, String name, int age, String email) {
		 String sql = "UPDATE customer SET name = ?, age = ?, email = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] {name, age, email, id});		
			return 1;
	}
	 public
	int delete (int id) {
		jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);		
			return 1;
	}	
	
	public
	customer read(int id) {
        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";
        return (customer) jdbcTemplate.queryForObject(
			sql, 	 	 
			(rs, rowNum) ->
				            new customer(
				                    rs.getInt("id"),
				                    rs.getString("name"),
				                    rs.getInt("age"),
				                    rs.getString("email")
				            			), new Object[]{id}
        					);
	 }	 
	 
	 @SuppressWarnings({ })
	public	
		List<customer> readAll() {
			 String sql = "SELECT * FROM customer";
			 List<customer> customers;
			 customers =  jdbcTemplate.query( sql,
		                (rs, rowNum) ->
		                        new customer(
		                                rs.getInt("id"),
		                                rs.getString("name"),
		                                rs.getInt("age"),
		                                rs.getString("email")
		                        )
		        );
			 return customers;
		}
		
		
		

}
