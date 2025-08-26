package net.javaguides.spring_boot_testing.service;

import net.javaguides.spring_boot_testing.model.Employee;
import net.javaguides.spring_boot_testing.repository.EmployeeRepository;
import net.javaguides.spring_boot_testing.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.Optional;

public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    @BeforeEach
    public void setup(){
       employeeRepository = Mockito.mock(EmployeeRepository.class);
       employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @DisplayName("JUnit test 4 saveEmployee method")
    @Test
    public void givenEmployeeObj_whenSaveEmployee_thenReturnEmploeeObj(){
        //given
        Employee employee = Employee.builder()
                .id(1L)
                .firstName("Ramish")
                .lastName("Fadatare")
                .email("ramish@gmail.com")
                .build();
        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());
        BDDMockito.given(employeeRepository.save(employee))
                .willReturn(employee);
        //when
        Employee savedEmployee = employeeService.saveEmployee(employee);
        //then
        Assertions.assertThat(savedEmployee).isNotNull();
    }

    @Test
    public void given1_when2_then3(){
        //given

        //when

        //then
    }
}
