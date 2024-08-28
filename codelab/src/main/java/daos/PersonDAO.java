package daos;

import entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import persistence.HibernateConfig;

public class PersonDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public void createPerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }
}
