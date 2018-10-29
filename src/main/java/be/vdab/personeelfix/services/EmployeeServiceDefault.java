package be.vdab.personeelfix.services;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.personeelfix.entities.Employee;
import be.vdab.personeelfix.repositories.EmployeeRepository;
import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class EmployeeServiceDefault implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceDefault(final EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	public Optional<Employee> read(final long employeeId) {
		return employeeRepository.findById(employeeId);
	}
	
	@Override
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void saveSSN(
			final long employeeId, final SocialSecurityNumber number) {
		employeeRepository.save(read(employeeId).get().saveSSN(number));
	}
}
