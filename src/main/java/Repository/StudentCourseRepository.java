package Repository;

import Entity.StudentCourse;

import java.util.List;

public interface StudentCourseRepository {
    void insertStudentCourse(StudentCourse studentCourse);
    void updateStudentCourse(StudentCourse studentCourse);
    void deleteStudentCourse(int studentCourseId);
    StudentCourse getStudentCourse(int studentCourseId);
    List<StudentCourse> getAllStudentCourses();
}
