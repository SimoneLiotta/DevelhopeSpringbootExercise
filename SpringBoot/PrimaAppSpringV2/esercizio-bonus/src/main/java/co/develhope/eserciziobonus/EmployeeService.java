package co.develhope.eserciziobonus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    void addNewEmployee(Employee employee){employeeRepository.save(employee);}
    Employee selectEmployeeById (Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(new Employee());
    }
    Employee updateSalaryEmployeeById(Long id, Double newSalary){
        Employee employee = employeeRepository.findById(id).orElse(new Employee());
        if (employee.getId()!=null) {
            employee.setSalary(newSalary);
            return employeeRepository.save(employee);
        } else {
            return new Employee();
        }

    }
    void deleteEmployeeById(Long id){employeeRepository.deleteById(id);}
    void deleteAllEmployee(){employeeRepository.deleteAll();}

}
