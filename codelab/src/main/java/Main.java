import daos.CourseDAO;
import daos.PersonDAO;
import entities.Course;
import entities.Person;

import daos.CourseDAO;
import daos.PersonDAO;
import entities.Course;
import entities.Person;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.createPerson(
                Person.builder()
                        .name("Hans")
                        .age(36)
                        .build()
        );

        CourseDAO courseDAO = new CourseDAO();

        // Create and persist a new course
        Course course = Course.builder()
                .courseName("Introduktion til Programmering")
                .teacher("Dr. Smith")
                .semester("Efterår 2024")
                .classroom("Rum 101")
                .time("MWF 10:00-11:00")
                .build();
        courseDAO.createCourse(course);

        // få id da det skal bruges for at kunne delete course
        int courseId = course.getId();

        // Update the course details
        course.setTeacher("Dr. Johnson");
        courseDAO.updateCourse(course);

        // Delete the course with the given ID
        courseDAO.deleteCourse(courseId);

        System.out.println("\n"+"Course with ID " + courseId + " deleted from the database.");
    }
}

