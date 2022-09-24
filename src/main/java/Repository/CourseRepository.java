package Repository;

import Entity.Course;

import java.util.List;

public interface CourseRepository {
    void insertCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
    Course getCourse(int courseId);
    List<Course> getAllCourses();
}
