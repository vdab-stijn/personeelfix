package be.vdab.personeelfix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.personeelfix.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public Optional<Employee> findById(final long employeeId);
}
