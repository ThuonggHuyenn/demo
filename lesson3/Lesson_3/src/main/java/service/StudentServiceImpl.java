package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    public List<Student> getAllStudent() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> lstData = studentDao.getAllStudent();
        return lstData;
    }

    public void insertStudent(Student student) {

    }

    public void updateStudent(Student student) {

    }

    public void deleteStudent(Student student) {

    }
}
