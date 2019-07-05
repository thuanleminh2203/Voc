package thuanlm.com.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import thuanlm.com.Demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Modifying
	@Transactional
	@Query(value= "delete e from employee e where e.id_company = ?1", nativeQuery = true) 
	int deleteByCompany(Integer id); 
	
}
 