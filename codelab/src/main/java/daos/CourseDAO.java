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

    public void updateCourse(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }
    }

    public void deleteCourse(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Course course = em.find(Course.class, id);
            if (course != null) {
                em.remove(course);
            }
            em.getTransaction().commit();
        }
    }

}
