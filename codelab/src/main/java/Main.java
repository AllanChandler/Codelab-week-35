import daos.PersonDAO;
import daos.StudentDAO;
import entities.Person;
import entities.Student;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
       /* PersonDAO personDAO = new PersonDAO();
        personDAO.createPerson(
                Person.builder()
                        .name("Hans")
                        .age(36)
                        .build()
        );*/

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.createStudent(
                Student.builder()
                        .name("Julie Petersen")
                        .phoneNumber("+4524366789")
                        .email("jp@gmail.com")
                        .address("Firskovvej 5")
                        .status("student")
                        .birthDate(LocalDate.of(1995,3,20))
                        .enrollmentDate(LocalDate.of(2023,9,1))
                        //Add courses here
                        .build()
        );


    }
}
