import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nguyen Quoc Dat");
        student.setAddress("Ha noi");
//
        StudentDao studentDao = new StudentDaoImpl();
//        StudentService studentService = new StudentServiceImpl();
//        studentService.getAllStudent().forEach(t -> {
//            System.out.println(t.toString());
//        });
//        studentDao.getAllStudent().forEach(System.out::println);
//            studentDao.searchStudentCriteria("B").forEach(t ->{
//                System.out.println(t.toString());
//            });
//        studentDao.insertStudent(student);
//        studentDao.insertStudentNative(student);

        Student studentUpdate = new Student();
        studentUpdate.setId(4);
//        studentUpdate.setName("Nguyen Van B");
//        studentUpdate.setAddress("Tp.HCM");

//        studentDao.updateStudent(studentUpdate);
//        studentDao.updateStudentNative(studentUpdate);

        studentDao.deleteStudent(studentUpdate);
//        studentDao.deleteStudentNative(5l);

//        List<Student> lst = studentDao.searchStudentCriteria("B");
//        lst.forEach(s -> {
//            System.out.println(s.toString());
//        });
    }
}
