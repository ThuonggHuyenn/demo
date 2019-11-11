package controller;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/api")
public class StudentController {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudent(){
//        return Arrays.asList(new Student("Demo", "111111111111"));
        StudentService studentService = new StudentServiceImpl();
        return studentService.getAllStudent();
    }

}
