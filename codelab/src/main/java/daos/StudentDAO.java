package daos;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import persistence.HibernateConfig;

public class StudentDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public void createStudent(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }
}
