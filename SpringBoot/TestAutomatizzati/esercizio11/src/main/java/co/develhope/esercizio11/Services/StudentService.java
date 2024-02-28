package co.develhope.esercizio11.Services;

import co.develhope.esercizio11.Entities.Student;
import co.develhope.esercizio11.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createNewStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    public Student studentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updateStudent) {
        Student myStudent = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Studente con id: " + id + " non trovato!"));
        if (updateStudent.getName() != null && !updateStudent.getName().isEmpty()){
            myStudent.setName(updateStudent.getName());
        }
        if (updateStudent.getSurname() != null && !updateStudent.getSurname().isEmpty()) {
            myStudent.setSurname(updateStudent.getSurname());
        }
        if (updateStudent.getIsWorking() != null ) {
            myStudent.setIsWorking(updateStudent.getIsWorking());
        }

        studentRepository.save(myStudent);
        return myStudent;

    }

    public Student updateStudentAttribute(Long id, Boolean isWorking) {
        Student myStudent = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Studente con id: " + id + " non trovato!"));

        myStudent.setIsWorking(isWorking);
        studentRepository.save(myStudent);
        return myStudent;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
