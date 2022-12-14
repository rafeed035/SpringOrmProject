package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
@Table(
        name = "student_course"
)
public class StudentCourse {
    @Id
    @SequenceGenerator(
            name = "studentCourse_id_sequence",
            sequenceName = "studentCourse_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "studentCourse_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "student_id"
    )
    @ManyToOne(
            cascade = javax.persistence.CascadeType.ALL
    )
    private Student student;
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "course_id"
    )
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Course course;

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public StudentCourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
