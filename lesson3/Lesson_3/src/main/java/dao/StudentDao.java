package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudent();

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    void insertStudentNative(Student student);

    void updateStudentNative(Student student);

    void deleteStudentNative(Long id);

    List<Student> searchStudentCriteria(String name);
}
