package Repository;

import Entity.Student;

import java.util.List;

public interface StudentRepository {
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    Student getStudent(int studentId);
    List<Student> getAllStudents();
}
