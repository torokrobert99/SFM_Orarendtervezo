package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaSubjectGroupDAO implements SubjectGroupsDAO {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void saveSubjectGroup(SubjectGroups a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteSubjectGroup(SubjectGroups a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateSubjectGroup(SubjectGroups a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<SubjectGroups> getSubjectGroup() {
        TypedQuery<SubjectGroups> query = entityManager.createQuery(
                "SELECT a FROM SubjectGroups a", SubjectGroups.class);
        List<SubjectGroups> SubjectGroups = query.getResultList();
        return SubjectGroups;
    }

    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }


}

