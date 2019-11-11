package service;

import entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
