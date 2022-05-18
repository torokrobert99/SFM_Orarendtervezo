package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaMySubjectsDAO implements MySubjectsDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveMySubjects(MySubjects a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteMySubjects(MySubjects a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateMySubjects(MySubjects a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<MySubjects> getMySubjects() {
        TypedQuery<MySubjects> query = entityManager.createQuery(
                "SELECT a FROM MySubjects a", MySubjects.class);
        List<MySubjects> Subjects = query.getResultList();
        return Subjects;
    }

    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
