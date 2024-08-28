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
        Course course = Course.builder()
                .courseName("Introduktion til Programmering")
                .teacher("Dr. Smith")
                .semester("Efterår 2024")
                .classroom("Rum 101")
                .time("MWF 10:00-11:00")
                .build();
        courseDAO.createCourse(course);
    }
}
