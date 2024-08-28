import daos.CourseDAO;
import daos.PersonDAO;
import daos.StudentDAO;

import entities.Course;
import entities.Person;
import entities.Student;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        PersonDAO personDAO = new PersonDAO();
        personDAO.createPerson(
                Person.builder()
                        .name("Hans")
                        .age(36)
                        .build()
        );
        */

        //instance of StudentDAO
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.createStudent(
                Student.builder()
                        .name("Julie Petersen")
                        .phoneNumber("+4524366789")
                        .email("jp@gmail.com")
                        .address("Firskovvej 5")
                        .status("student")
                        .birthDate(LocalDate.of(1995, 3, 20))
                        .enrollmentDate(LocalDate.of(2023, 9, 1))
                        //Add courses here
                        .build()
        );

        Student student = studentDAO.getById(1);

        student.setName("Karen Kjeldsen");
        student.setAddress("Hovedgaden 12");
        student.setEmail("kk@gmail.com");
        studentDAO.updateStudentInfo(student);

        //To update all info use this method structure
        /*
        userDAO.update(
                        User.builder()
                                .id(1)
                                .username("user2")
                                .password("password123")
                                .email("someemail@gmail.com")
                                .build()
                );
        */

        //Delete a student
        studentDAO.deleteStudent(student);

        // create course
        CourseDAO courseDAO = new CourseDAO();
        Course course = Course.builder()
                .courseName("Introduktion til Programmering")
                .teacher("Dr. Smith")
                .semester("Efterår 2024")
                .classroom("Rum 101")
                .time("MWF 10:00-11:00")
                .build();
        courseDAO.createCourse(course);

        // update course
        course.setTeacher("Dr. Johnson");
        courseDAO.updateCourse(course);

        //List all courses
        List<Course> courses = courseDAO.getAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (Course course2 : courses) {
                System.out.println(course2);
            }
        }

    }
}
