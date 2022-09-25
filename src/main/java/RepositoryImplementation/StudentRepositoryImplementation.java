package RepositoryImplementation;

import Entity.Student;
import Repository.StudentRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentRepositoryImplementation implements StudentRepository {

    private HibernateTemplate hibernateTemplate;

    public StudentRepositoryImplementation(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    @Override
    public void insertStudent(Student student) {
        hibernateTemplate.save(student);
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        hibernateTemplate.update(student);
    }

    @Transactional
    @Override
    public void deleteStudent(int studentId) {
        hibernateTemplate.delete(studentId);
    }

    @Override
    public Student getStudent(int studentId) {
        return hibernateTemplate.get(Student.class, studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = hibernateTemplate.loadAll(Student.class);
        return students;
    }
}
