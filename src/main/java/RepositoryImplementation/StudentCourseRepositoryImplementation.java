package RepositoryImplementation;

import Entity.Student;
import Entity.StudentCourse;
import Repository.StudentCourseRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.ClientInfoStatus;
import java.util.List;

public class StudentCourseRepositoryImplementation implements StudentCourseRepository {

    private HibernateTemplate hibernateTemplate;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public StudentCourseRepositoryImplementation(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public void insertStudentCourse(StudentCourse studentCourse) {
        hibernateTemplate.save(studentCourse);
    }

    @Transactional
    @Override
    public void updateStudentCourse(StudentCourse studentCourse) {
        hibernateTemplate.update(studentCourse);
    }

    @Transactional
    @Override
    public void deleteStudentCourse(int studentCourseId) {
        hibernateTemplate.delete(studentCourseId);
    }

    @Override
    public StudentCourse getStudentCourse(int studentCourseId) {
        return hibernateTemplate.get(StudentCourse.class, studentCourseId);
    }

    @Override
    public List<StudentCourse> getAllStudentCourses(int studentId) {
        Query query = entityManager.createQuery("select * from student_course where student_id = " + studentId);
        List<StudentCourse> studentCourses = query.getResultList();
        return studentCourses;
    }
}
