package daos;

import entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import persistence.HibernateConfig;

public class CourseDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public void createCourse(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
    }

}
