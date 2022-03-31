package hu.unideb.inf.model;

import java.util.List;

public interface PersonDAO extends AutoCloseable{
    public void savePerson(Person a);
    public void deletePerson(Person a);
    public void updatePerson(Person a);
    public List<Person> getPersons();
    public default void saveSchool(School school){
        throw new UnsupportedOperationException();
    }
}
