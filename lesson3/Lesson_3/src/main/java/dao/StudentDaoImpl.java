package dao;

import entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import utils.HibernateUtil;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    public List<Student> getAllStudent() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Student> lst = session.createQuery("from Student ").getResultList();
            session.getTransaction().commit();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public void insertStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Insert to database success!");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            System.out.println("Update to database success!");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void deleteStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
            System.out.println("Delete success id: " + student.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    //============================================== NativeSQL =========================================================
    public List<Student> getAllStudentNative() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            NativeQuery<Student> query = session.createNativeQuery("select ID id, NAME name, ADDRESS address from student");
            query.addScalar("id", new IntegerType())
                    .addScalar("name", new StringType()).addScalar("address", new StringType());
            //            //query.addEntity(Student.class) ;
            query.setResultTransformer(Transformers.aliasToBean(Student.class));
            List<Student> lst = query.getResultList();
            session.getTransaction().commit();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public void insertStudentNative(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String sql = "INSERT INTO STUDENT (NAME, ADDRESS) VALUES (:p_name, :p_address)";
            NativeQuery query = session.createNativeQuery(sql);
            query.setParameter("p_name", student.getName()).setParameter("p_address", student.getAddress())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void updateStudentNative(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String sql = "update STUDENT set NAME = :p_name where id = :p_id";
            NativeQuery query = session.createNativeQuery(sql);
            query.setParameter("p_name", student.getName()).setParameter("p_id", student.getId()).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void deleteStudentNative(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String sql = "delete from STUDENT where id = :p_id";
            NativeQuery query = session.createNativeQuery(sql);
            query.setParameter("p_id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    //========================================= Criteria ===============================================================
    public List<Student> searchStudentCriteria(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.like("name", name));
            List<Student> students = criteria.list();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }
}
