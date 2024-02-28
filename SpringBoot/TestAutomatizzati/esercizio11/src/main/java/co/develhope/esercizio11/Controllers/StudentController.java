package co.develhope.esercizio11.Controllers;

import co.develhope.esercizio11.Entities.Student;
import co.develhope.esercizio11.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    Student createStudent(@RequestBody Student student) {
        return studentService.createNewStudent(student);
    }

    @GetMapping("/list")
    List<Student> getAllStudents() {
        return studentService.studentList();
    }

    @GetMapping("/studentById/{id}")
    Student getStudentById(@PathVariable Long id) {
        return studentService.studentById(id);
    }

    @PutMapping("/updateStudent/{id}")
    Student updateStudent(@PathVariable Long id, @RequestBody Student updateStudent) {
        return studentService.updateStudent(id, updateStudent);
    }

    @PutMapping("/updateParameter/{id}")
    Student updateIsWorkingStudent(@PathVariable Long id, @RequestParam Boolean working) {
        return studentService.updateStudentAttribute(id, working);
    }

    @DeleteMapping("/delete/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
