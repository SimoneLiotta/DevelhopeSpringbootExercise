package co.develhope.esercizio11;

import co.develhope.esercizio11.Entities.Student;
import co.develhope.esercizio11.Repositories.StudentRepository;
import co.develhope.esercizio11.Services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "test")
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    private Student createStudent(){
        Student student = new Student();
        student.setId(1L);
        student.setName("Simone");
        student.setSurname("Liotta");
        student.setIsWorking(true);
        return student;
    }

    @Test
    void studentUpdateIsWorkingTest() throws Exception{
        Student student = createStudent();

        Student studentFromDB = studentRepository.save(student);
        assertThat(studentFromDB).isNotNull();
        assertThat(studentFromDB.getId()).isNotNull();

        Student studentFromService = studentService.updateStudentAttribute(studentFromDB.getId(), false);
        assertThat(studentFromService).isNotNull();
        assertThat(studentFromService.getId()).isNotNull();
        assertThat(studentFromService.getIsWorking()).isEqualTo(false);
    }

    @Test
    void studentUpdateTest() throws Exception{
        Student student = createStudent();

        Student updateStudent = new Student();
//        updateStudent.setName("Mario");
        updateStudent.setSurname("Rossi");
        updateStudent.setIsWorking(true);

        Student studentFromDB = studentRepository.save(student);
        assertThat(studentFromDB).isNotNull();
        assertThat(studentFromDB.getId()).isNotNull();

        Student studentFromService = studentService.updateStudent(studentFromDB.getId(), updateStudent);
        assertThat(studentFromService).isNotNull();
        assertThat(studentFromService.getId()).isNotNull();

//        assertThat(studentFromService.getName()).isEqualTo("Mario");
        assertThat(studentFromService.getSurname()).isEqualTo("Rossi");
        assertThat(studentFromService.getIsWorking()).isEqualTo(true);
    }
}
