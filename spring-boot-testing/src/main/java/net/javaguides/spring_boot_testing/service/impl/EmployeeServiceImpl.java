package net.javaguides.spring_boot_testing.service.impl;

import net.javaguides.spring_boot_testing.exception.ResourceNotFoundException;
import net.javaguides.spring_boot_testing.model.Employee;
import net.javaguides.spring_boot_testing.repository.EmployeeRepository;
import net.javaguides.spring_boot_testing.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //@Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        Optional<Employee> savedEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (savedEmployee.isPresent()) {
            throw new ResourceNotFoundException("Employee alredy exists with given email" + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }

}
