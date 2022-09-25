package RepositoryImplementation;

import Entity.StudentCourse;
import Repository.StudentCourseRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentCourseRepositoryImplementation implements StudentCourseRepository {

    private HibernateTemplate hibernateTemplate;

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
    public List<StudentCourse> getAllStudentCourses() {
        List<StudentCourse> studentCourses = hibernateTemplate.loadAll(StudentCourse.class);
        return studentCourses;
    }
}
