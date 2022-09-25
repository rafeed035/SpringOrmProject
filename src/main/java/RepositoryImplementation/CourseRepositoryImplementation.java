package RepositoryImplementation;

import Entity.Course;
import Repository.CourseRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseRepositoryImplementation implements CourseRepository {

    private HibernateTemplate hibernateTemplate;

    public CourseRepositoryImplementation(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public void insertCourse(Course course) {
        hibernateTemplate.save(course);
    }

    @Transactional
    @Override
    public void updateCourse(Course course) {
        hibernateTemplate.update(course);
    }

    @Transactional
    @Override
    public void deleteCourse(int courseId) {
        hibernateTemplate.delete(courseId);
    }

    @Override
    public Course getCourse(int courseId) {
        return hibernateTemplate.get(Course.class, courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = hibernateTemplate.loadAll(Course.class);
        return courses;
    }
}
