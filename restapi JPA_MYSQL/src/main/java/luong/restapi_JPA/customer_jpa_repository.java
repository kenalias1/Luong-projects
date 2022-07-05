package luong.restapi_JPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customer_jpa_repository extends JpaRepository<customer, Integer>  {
	   public customer findByName(String name);
}
