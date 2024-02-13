package co.develhope.eserciziobonus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    @Operation(summary = "Aggiunge un nuovo impiegato alla lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    void newEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }
    @GetMapping("/list")
    @Operation(summary = "Restituisce la lista di tutti gli impiegati")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/employeeById/{id}")
    @Operation(summary = "Restituisce l'impiegato corrispondente all'id selezionato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    Employee selectEmployeeById(@PathVariable Long id){return employeeService.selectEmployeeById(id);}
    @PutMapping("/updateSalary/{id}")
    @Operation(summary = "Aggiorna il salario dell'impiegato corrispondente all'id selezionato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    Employee updateSalaryEmployeeById(@PathVariable Long id, @RequestParam Double salary){
        return employeeService.updateSalaryEmployeeById(id, salary);
    }
    @DeleteMapping("/deleteAll")
    @Operation(summary = "Elimina tutti gli impiegati dalla lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    void deleteAllEmployee(){employeeService.deleteAllEmployee();}
    @DeleteMapping("/deleteById/{id}")
    @Operation(summary = "Elimina dalla lista l'impiegato corrispondente all'id selezionato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400",description = "Bad request")
    })
    void deleteEmployeeById(@PathVariable Long id){employeeService.deleteEmployeeById(id);}

}
