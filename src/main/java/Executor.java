import Entity.Course;
import Entity.Department;
import Entity.Student;
import Entity.StudentCourse;
import Repository.CourseRepository;
import Repository.DepartmentRepository;
import Repository.StudentCourseRepository;
import Repository.StudentRepository;
import RepositoryImplementation.CourseRepositoryImplementation;
import RepositoryImplementation.DepartmentRepositoryImplementation;
import RepositoryImplementation.StudentCourseRepositoryImplementation;
import RepositoryImplementation.StudentRepositoryImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Executor {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");

        DepartmentRepository departmentRepositoryImplementation
                = (DepartmentRepository) applicationContext.getBean("departmentRepositoryImplementation");

        CourseRepository courseRepositoryImplementation
                = (CourseRepository) applicationContext.getBean("courseRepositoryImplementation");

        StudentRepository studentRepositoryImplementation
                = (StudentRepository) applicationContext.getBean("studentRepositoryImplementation");

        StudentCourseRepository studentCourseRepositoryImplementation
                = (StudentCourseRepository) applicationContext.getBean("studentCourseRepositoryImplementation");


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean runApplication = true;

        while(runApplication){

            System.out.println("==================Welcome to College Record=================");
            System.out.println("\n");

            List<Department> departments = departmentRepositoryImplementation.getAllDepartments();
            System.out.println("Total Departments : " + departments.size());

            List<Course>courses = courseRepositoryImplementation.getAllCourses();
            System.out.println("Total Courses : " + courses.size());

            List<Student>students = studentRepositoryImplementation.getAllStudents();
            System.out.println("Total Students : " + students.size());

            System.out.println("\n");
            System.out.println("=================Options=================");

            System.out.println("\n" +
                    "1. View all Departments  " +
                    "2. View a Department  " +
                    "3. Add new Department  " +
                    "4. Update a Department  " +
                    "5. Delete a Department  " +
                    "\n\n" +
                    "6. View all Courses  " +
                    "7. View a Course  " +
                    "8. Add new Course  " +
                    "9. Update a Course  " +
                    "10. Delete a Course  " +
                    "\n\n" +
                    "11. View all Students  " +
                    "12. View a Student  " +
                    "13. Add new Student  " +
                    "14. Update a Student  " +
                    "15. Delete a Student  " +
                    "\n\n" +
                    "16. Exit");

            System.out.println("\n=================Your Choice=================");
            System.out.println("\nYour Choice: ");
            System.out.println("-----------------------------------------------------------------------------------");
            try {
                int choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice){

                    //Department
                    //view all departments
                    case 1:
                        for(int i = 0; i < departments.size(); i++){
                            System.out.println(departments.get(i).getDepartmentId() + " " + departments.get(i).getDepartmentName());
                        }
                        System.out.println("\n");
                        break;

                    //view a Department
                    case 2:
                        System.out.println("Enter Department Id: ");
                        int departmentChoice = Integer.parseInt(bufferedReader.readLine());

                        Department department = departmentRepositoryImplementation.getDepartment(departmentChoice);
                        System.out.println(department.getDepartmentId() + " " + department.getDepartmentName());
                        System.out.println("\n");
                        break;

                    //add a new Department
                    case 3:
                        System.out.println("Enter Department Id: ");
                        int departmentId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Department Name: ");
                        String departmentName = bufferedReader.readLine();

                        Department departmentNew = new Department(departmentId, departmentName);
                        departmentRepositoryImplementation.insertDepartment(departmentNew);
                        System.out.println("New Department Inserted");
                        System.out.println("\n");
                        break;

                    //update a Department
                    case 4:
                        System.out.println("Enter Department Id: ");
                        int updateDepartmentId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Department Name: ");
                        String updateDepartmentName = bufferedReader.readLine();

                        Department updateDepartment = new Department(updateDepartmentId, updateDepartmentName);
                        departmentRepositoryImplementation.updateDepartment(updateDepartment);
                        System.out.println("Updated Department");
                        System.out.println("\n");
                        break;

                    //delete a Department
                    case 5:
                        System.out.println("Enter Department Id: ");
                        int deleteDepartmentId = Integer.parseInt(bufferedReader.readLine());

                        departmentRepositoryImplementation.deleteDepartment(deleteDepartmentId);
                        System.out.println("Department Deleted");
                        System.out.println("\n");
                        break;

                    //Courses
                    //view all Courses
                    case 6:
                        for(int i = 0; i < courses.size(); i++){
                            Department allCourseDepartments = departmentRepositoryImplementation.getDepartment(courses.get(i).getDepartment().getDepartmentId());
                            String allCoursesDepartmentName = allCourseDepartments.getDepartmentName();
                            System.out.println(courses.get(i).getCourseId() +
                                    " | " +
                                    courses.get(i).getCourseName() +
                                    " | " +
                                    "Department : " + allCoursesDepartmentName);
                        }
                        System.out.println("\n");
                        break;

                    //view a particular Course
                    case 7:
                        System.out.println("Enter Course Id: ");
                        int courseId = Integer.parseInt(bufferedReader.readLine());

                        Course course = courseRepositoryImplementation.getCourse(courseId);

                        if(course != null){
                            Department courseDepartment = courseRepositoryImplementation.getCourse(courseId).getDepartment();
                            String courseDepartmentName = courseDepartment.getDepartmentName();
                            System.out.println(course.getCourseId() +
                                    " | " +
                                    course.getCourseName() +
                                    " | " +
                                    "Department : " + courseDepartmentName);
                        }
                        else{
                            System.out.println("Course with id: " + courseId + " does not exists.");
                        }
                        System.out.println("\n");
                        break;

                    //add a new Course
                    case 8:
                        System.out.println("Enter Course Id: ");
                        int newCourseId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Course Name: ");
                        String newCourseName = bufferedReader.readLine();

                        System.out.println("Enter Department Id: ");
                        int newCourseDepartmentId = Integer.parseInt(bufferedReader.readLine());

                        Department newCourseDepartment = departmentRepositoryImplementation.getDepartment(newCourseDepartmentId);

                        if(newCourseDepartment == null){

                        }
                        else{
                            Course newCourse = new Course(newCourseId, newCourseName, newCourseDepartment);
                            courseRepositoryImplementation.insertCourse(newCourse);
                            System.out.println("New Course Inserted");
                        }
                        System.out.println("\n");
                        break;

                    //update a new Course
                    case 9:
                        System.out.println("Enter Course Id: ");
                        int updateCourseId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Course Name: ");
                        String updateCourseName = bufferedReader.readLine();

                        System.out.println("Enter Department Id: ");
                        int updateCourseDepartmentId = Integer.parseInt(bufferedReader.readLine());

                        Department updateCourseDepartment = departmentRepositoryImplementation.getDepartment(updateCourseDepartmentId);

                        if(updateCourseDepartment == null){
                            System.out.println("Department with id: " + updateCourseDepartmentId + " does not exist. Please add the Department first.");
                        }
                        else{
                            Course updateCourse = new Course(updateCourseId, updateCourseName, updateCourseDepartment);
                            courseRepositoryImplementation.updateCourse(updateCourse);
                            System.out.println("Course Updated");
                        }
                        System.out.println("\n");
                        break;

                    // delete a Course
                    case 10:
                        System.out.println("Enter Course Id: ");
                        int deleteCourseId = Integer.parseInt(bufferedReader.readLine());

                        courseRepositoryImplementation.deleteCourse(deleteCourseId);
                        System.out.println("Deleted Course");

                        System.out.println("\n");
                        break;

                    //Student
                    //view all Students
                    case 11:
                        for(int i = 0; i < students.size(); i++){
                            System.out.println(students.get(i).getStudentId() +
                                    " | Name: " +
                                     students.get(i).getStudentName() +
                                    " | Address : " +
                                    students.get(i).getStudentAddress());
                        }
                        System.out.println("\n");
                        break;

                    //view a Student
                    case 12:
                        System.out.println("Enter Student Id: ");
                        int studentId = Integer.parseInt(bufferedReader.readLine());
                        Student student = studentRepositoryImplementation.getStudent(studentId);
                        List<StudentCourse> studentCourses = studentCourseRepositoryImplementation.getAllStudentCourses();

                        System.out.println(student.getStudentId() +
                                " | Name: " +
                                student.getStudentName() +
                                " | Address : " +
                                student.getStudentAddress());

                        System.out.println("\n Courses taken:");

                        for(int i = 0; i < studentCourses.size(); i++){
                            int studentIdToMatch = studentCourses.get(i).getStudent().getStudentId();
                            String courseName = null;
                            if(studentIdToMatch == studentId){
                                courseName = studentCourses.get(i).getCourse().getCourseName();
                            }
                            else{
                                courseName = "No Course";
                            }

                            System.out.println(i+1 + " " + courseName);
                        }

                        System.out.println("\n");
                        break;

                    //add a new Student
                    case 13:
                        System.out.println("Enter Student Id: ");
                        int newStudentId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Student Name: ");
                        String newStudentName = bufferedReader.readLine();

                        System.out.println("Enter Student Address: ");
                        String newStudentAddress = bufferedReader.readLine();

                        Student studentNew = new Student(newStudentId, newStudentName, newStudentAddress);
                        studentRepositoryImplementation.insertStudent(studentNew);

                        System.out.println("\nSelect the courses. Maximum 5 courses.");
                        List<Course>courseList = courseRepositoryImplementation.getAllCourses();
                        for(int i = 0; i < courseList.size(); i++){
                            Department courseDepartment = departmentRepositoryImplementation.getDepartment(courseList.get(i).getDepartment().getDepartmentId());
                            String courseDepartmentName = courseDepartment.getDepartmentName();
                            System.out.println(courseList.get(i).getCourseId() +
                                    " | Course Name: " +
                                     courseList.get(i).getCourseName()+
                                    " | Department Name: " +
                                    courseDepartmentName);
                        }
                        System.out.println("Your choice: ");
                        for(int i = 0; i < 5; i++){
                            int courseChoice = Integer.parseInt(bufferedReader.readLine());
                            Course studentCourseChoice = courseRepositoryImplementation.getCourse(courseChoice);
                            StudentCourse studentCourse = new StudentCourse(studentNew, studentCourseChoice);
                            studentCourseRepositoryImplementation.insertStudentCourse(studentCourse);
                        }

                        System.out.println("New Student inserted");

                        System.out.println("\n");
                        break;

                    //update a Student
                    case 14:
                        System.out.println("Enter Student Id: ");
                        int updateStudentId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter Student Name: ");
                        String updateStudentName = bufferedReader.readLine();

                        System.out.println("Enter Student Address: ");
                        String updateStudentAddress = bufferedReader.readLine();

                        Student studentUpdate = new Student(updateStudentId, updateStudentName, updateStudentAddress);
                        studentRepositoryImplementation.updateStudent(studentUpdate);

                        Student studentUpdated = studentRepositoryImplementation.getStudent(updateStudentId);

                        System.out.println("Update Courses? Type Y for yes and N for no");
                        String ynChoice = bufferedReader.readLine();
                        if(ynChoice.equals("Y") || ynChoice.equals("y")){
                            System.out.println("\nSelect the courses. Maximum 5 courses.");
                            List<Course>updateCourseList = courseRepositoryImplementation.getAllCourses();
                            for(int i = 0; i <updateCourseList.size(); i++){
                                String updateCourseDepartmentName = departmentRepositoryImplementation
                                        .getDepartment(updateCourseList
                                                .get(i)
                                                .getDepartment()
                                                .getDepartmentId())
                                        .getDepartmentName();
                                System.out.println(updateCourseList.get(i).getCourseId() +
                                        " | Name: " +
                                        updateCourseList.get(i).getCourseName() +
                                        " | Department Name: " +
                                        updateCourseDepartmentName);
                                System.out.println("\nYour Choice: ");
                                for(int j = 0; j < 5; j++){
                                    int updateCourseChoice = Integer.parseInt(bufferedReader.readLine());
                                    Course updateCourse = courseRepositoryImplementation.getCourse(updateCourseChoice);
                                    StudentCourse updateStudentCourse = new StudentCourse(studentUpdated, updateCourse);
                                    studentCourseRepositoryImplementation.updateStudentCourse(updateStudentCourse);
                                }
                            }
                        }else{
                            System.out.println("No courses updated/changed.");
                        }

                        System.out.println("Student updated");

                        System.out.println("\n");
                        break;

                    //delete a Student
                    case 15:
                        System.out.println("Enter Student Id: ");
                        int studentDeleteId = Integer.parseInt(bufferedReader.readLine());

                        studentRepositoryImplementation.deleteStudent(studentDeleteId);
                        System.out.println("Deleted Student ");

                        System.out.println("\n");
                        break;

                    case 16:
                        runApplication = false;
                        break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
