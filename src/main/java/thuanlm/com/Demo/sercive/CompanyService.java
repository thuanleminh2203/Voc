package thuanlm.com.Demo.sercive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thuanlm.com.Demo.entity.Company;
import thuanlm.com.Demo.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	public Company create(Company company) {

		return companyRepository.save(company);
	}

	public Optional<Company> findByID(int id) {
		return companyRepository.findById(id);
	}

	public void delete(Company company) {

		companyRepository.delete(company);
	}
}
