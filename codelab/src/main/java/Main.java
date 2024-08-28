import daos.PersonDAO;
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


    }
}
