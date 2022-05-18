
/** MÉG NEM KELL **/

/*package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaSubjectDAO implements SubjectDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveSubject(Subject a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteSubject(Subject a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateSubject(Subject a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Subject> getSubjects() {
        TypedQuery<Subject> query = entityManager.createQuery(
                "SELECT a FROM Subject a", Subject.class);
        List<Subject> Subjects = query.getResultList();
        return Subjects;
    }

    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

} */
