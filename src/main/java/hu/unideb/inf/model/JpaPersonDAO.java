package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaPersonDAO implements PersonDAO{

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void savePerson(Person a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletePerson(Person a) {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updatePerson(Person a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Person> getPersons() {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT a FROM Person a", Person.class);
        List<Person> Persons = query.getResultList();
        return Persons;
    }

    @Override
    public void saveSchool(School school) {
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
