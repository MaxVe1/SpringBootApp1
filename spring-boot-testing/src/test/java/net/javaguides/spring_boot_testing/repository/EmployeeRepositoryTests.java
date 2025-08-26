package net.javaguides.spring_boot_testing.repository;

import net.javaguides.spring_boot_testing.model.Employee;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;
    @BeforeEach
    public void setUp(){
        employee = Employee.builder()
                .firstName("Remesh")
                .lastName("Ramish")
                .email("ramesh@gmail.com")
                .build();
    }

    @DisplayName("JUnit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){
        //given
        // beforeeach
//        Employee employee = Employee.builder()
//        .firstName("Remesh")
//        .lastName("Ramish")
//        .email("ramesh@gmail.com")
//        .build();
        //when
        Employee savedEmployee = employeeRepository.save(employee);
        //then
        //Assertions.assertThat(savedEmployee).isNotNull();
        //Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
        assertThat(savedEmployee.getId()).isGreaterThan(0);
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenEmployeesList_whenFindAll_thenEmployee2List() {
        //given
//        Employee employee1 = Employee.builder()
//                .firstName("Remesha")
//                .lastName("Ramishi")
//                .email("ramesh1@gmail.com")
//                .build();

        Employee employee2 = Employee.builder()
                .firstName("John")
                .lastName("Conor")
                .email("conor1@gmail.com")
                .build();
        //when
        Employee savedEmployee1 = employeeRepository.save(employee);
        Employee savedEmployee2 = employeeRepository.save(employee2);
        //when
        List<Employee> employeesList = employeeRepository.findAll();
        //then
        Assertions.assertThat(employeesList).isNotNull();
        Assertions.assertThat(employeesList.size()).isEqualTo(2);
    }
    @DisplayName("JUnit test for get employee by ID operation")
    @Test
    public void givenEmployeeObject_whenFindBuId_thenReturnEmployeeObject() {
        //given
//        Employee employee3 = Employee.builder()
//                .firstName("Remesha")
//                .lastName("Ramishi")
//                .email("ramesh1@gmail.com")
//                .build();
        employeeRepository.save(employee);
        //when
        Employee employeeDB = employeeRepository.findById(employee.getId()).get();
        //then
        Assertions.assertThat(employeeDB).isNotNull();
    }

    @DisplayName("JUnit test for get employee by email operation")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {
//        //given
//        Employee employee32 = Employee.builder()
//                .firstName("Remesha")
//                .lastName("Fadatare")
//                .email("ramesh11@gmail.com")
//                .build();
        employeeRepository.save(employee);
        //when
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();
        //then
        assertThat(employeeDB).isNotNull();
    }

    @DisplayName("JUnit test for update employee operation")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        //given
//        Employee employee = Employee.builder()
//                .firstName("Remesha")
//                .lastName("Fadatare")
//                .email("ramesh11@gmail.com")
//                .build();
        employeeRepository.save(employee);
        //when
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("ram@gmail.com");
        savedEmployee.setFirstName("Ram");

        Employee updatedEmployee = employeeRepository.save(savedEmployee);
        //then
        assertThat(updatedEmployee.getEmail()).isEqualTo("ram@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Ram");
    }
    // 15Video and 18,19 video не написано delete-operation, sql
    /*
    @DisplayName("JUnit test for get employee by email operation")
    @Test
    public void given1_when2_then3() {
        //given
        Employee employee32 = Employee.builder()
                .firstName("Remesha")
                .lastName("Fadatare")
                .email("ramesh11@gmail.com")
                .build();
        employeeRepository.save(employee32);
        //when
        Employee employeeDB = employeeRepository.findByEmail(employee32.getEmail()).get();
        //then
        assertThat(employeeDB).isNotNull();
    }
    * */


    @DisplayName("JUnit test for custom query using JPQL with index")
    @Test
    public void given1stAndLastName_whenFindByJPQL_thenReturnEmployeeObj() {
        //given
        Employee employee32 = Employee.builder()
                .firstName("Remesha")
                .lastName("Fadatare")
                .email("ramesh01@gmail.com")
                .build();
        employeeRepository.save(employee32);
        String firstName = "Remesha";
        String lastName = "Fadatare";
        //when
        Employee savedEmployee  = employeeRepository.findByJPQL(firstName, lastName );
        //then
        assertThat(savedEmployee).isNotNull();
    }

}
