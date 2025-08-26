package net.javaguides.spring_boot_testing.service;

import net.javaguides.spring_boot_testing.model.Employee;
import net.javaguides.spring_boot_testing.repository.EmployeeRepository;
import net.javaguides.spring_boot_testing.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
    @BeforeEach
    public void setup(){
       //employeeRepository = Mockito.mock(EmployeeRepository.class);
       //employeeService = new EmployeeServiceImpl(employeeRepository);

        employee = Employee.builder()
                .id(1L)
                .firstName("Ramish")
                .lastName("Fadatare")
                .email("ramish@gmail.com")
                .build();
    }

    @DisplayName("JUnit test 4 saveEmployee method")
    @Test
    public void givenEmployeeObj_whenSaveEmployee_thenReturnEmploeeObj(){
        //given

        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());
        given(employeeRepository.save(employee))
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
