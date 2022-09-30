# SpringOrmProject
This is a project implementing Spring ORM (Hibernate) features.
The Project is a demo record system of a college.
Where details about the Department, Courses and the Students will be recorded.
Also, will be recorded the courses taken by each student. This is a basic CRUD application with the Spring framework using ORM (Hibernate).

**How to run the application:**

1. Clone/Download the project.
2. Import/Open the project in any IDE (example - Intellij IDEA [community/ultimate], NetBeans, etc).
3. Open MySQL workbench or any other MySQL work environment.
4. Create a database and name it - "spring_core_db"
5. Create the department, course, student, and the student_course table.
6. To Create the department table copy-paste and run the following on the MySQL workbench-
`   create table department(
   department_id int primary key not null,
   department_name varchar(100) not null
   );`

7. To create the course table copy-paste and run the following on the MySQL workbench-
`   create table course(
   course_id int primary key not null,
   course_name varchar(100) not null,
   department_id int not null,
   foreign key(department_id)
   references department(department_id)
   on delete cascade
   on update cascade
   );`
8. To create the student table copy-paste and run the following on the MySQL workbench-
`   create table student(
   student_id int not null primary key,
   student_name varchar(100) not null,
   student_address varchar(200) not null
   );`
9. To create the student_course table copy-paste and run the following on the MySQL workbench-
`   create table student_course(
   id int primary key not null,
   student_id int not null,
   course_id int not null,
   foreign key(student_id)
   references student(student_id)
   on delete cascade
   on update cascade,
   foreign key(course_id)
   references course(course_id)
   on delete cascade
   on update cascade
   );`
10. Open the Project file, and go to the resources folder and find the following xml file - config.class.
11. Find the following bean, and change the userName and the password to your MySQL userName and password.
`    <bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" name="driverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/spring_core_db"/>
    <property name="username" value="user_name"/>
    <property name="password" value="password"/>
    </bean>`

12. Run the application.
