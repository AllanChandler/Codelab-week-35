package daos;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import persistence.HibernateConfig;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Student> getAllStudents() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
            List<Student> studentList = query.getResultList();
            return studentList.stream().collect(Collectors.toSet());
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
