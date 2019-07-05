package thuanlm.com.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thuanlm.com.Demo.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
