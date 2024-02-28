package co.develhope.esercizio11;

import co.develhope.esercizio11.Controllers.StudentController;
import co.develhope.esercizio11.Entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "test")
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoad() {
        assertThat(studentController).isNotNull();
    }

    private Student createStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Simone");
        student.setSurname("Liotta");
        student.setIsWorking(true);

        String studentJSon = objectMapper.writeValueAsString(student);

        MvcResult result = this.mockMvc.perform(post("/student/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJSon))
                .andExpect(status().isOk())
                .andReturn();

        String studentJSon1 = result.getResponse().getContentAsString();
        return objectMapper.readValue(studentJSon1, Student.class);
    }

    private Student getStudentFromId(Long id) throws Exception {
        MvcResult result = this.mockMvc.perform(get("/student/studentById/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        try {
            String studentJSon = result.getResponse().getContentAsString();
            return objectMapper.readValue(studentJSon, Student.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    void createStudentTest() throws Exception {
        Student student = createStudent();
        assertThat(student.getId()).isNotNull();
    }

    @Test
    void getStudentByIdTest() throws Exception {

        Student student = createStudent();
        assertThat(student.getId()).isNotNull();
        Student studentResponse = getStudentFromId(student.getId());
        assertThat(studentResponse.getId()).isEqualTo(student.getId());
    }

    @Test
    void deleteStudentTest() throws Exception {
        Student student = createStudent();
        assertThat(student.getId()).isNotNull();

        this.mockMvc.perform(delete("/student/delete/" + student.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Student studentFromResponseGet = getStudentFromId(student.getId());
        assertThat(studentFromResponseGet).isNull();
    }

    @Test
    void updateStudentWorkingTest() throws Exception{
        Student student = createStudent();
        assertThat(student.getId()).isNotNull();

        MvcResult result = this.mockMvc.perform(put("/student/updateParameter/" + student.getId() + "?working=false"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Student studentFromResponsePut = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
        assertThat(studentFromResponsePut.getId()).isEqualTo(student.getId());
        assertThat(studentFromResponsePut.getIsWorking()).isEqualTo(false);

    }


}
