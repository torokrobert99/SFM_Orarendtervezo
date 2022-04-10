package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTeacherDAO implements TeacherDAO{
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public void saveTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.remove(teacher);
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Teacher> getTeachers() {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "SELECT a FROM Teacher a", Teacher.class);
        List<Teacher> Teachers = query.getResultList();
        return Teachers;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
