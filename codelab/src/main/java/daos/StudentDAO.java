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

    public void updateStudentInfo(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
    }

   public Student getById(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
           return em.find(Student.class, id);
        }
    }

    public void deleteStudent(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }
    }
}
