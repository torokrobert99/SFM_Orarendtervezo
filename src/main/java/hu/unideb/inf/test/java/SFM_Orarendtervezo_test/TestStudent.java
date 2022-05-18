package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.Student;
import hu.unideb.inf.model.Person;


public class TestStudent {

    @Test
    public void testStudent() {
        Student s = new Student();
        s.setName("Példa Péter");
        s.setAge(21);
        s.setRole(Person.RoleType.STUDENT);
        s.setUsername("peldapeter99");
        s.setPassword("alma123");
        assertEquals("Példa Péter", s.getName());
        assertEquals(21, s.getAge());
        assertEquals(Person.RoleType.STUDENT, s.getRole());
        assertEquals("peldapeter99", s.getUsername());
        assertEquals("alma123", s.getPassword());
    }

    @Test
    public void testSetName() {
        Student s = new Student();
        s.setName("Példa Péter");
        assertEquals("Példa Péter", s.getName());
    }

    @Test
    public void testSetAge() {
        Student s = new Student();
        s.setAge(21);
        assertEquals(21, s.getAge());
    }

    @Test
    public void testSetRole() {
        Student s = new Student();
        s.setRole(Person.RoleType.STUDENT);
        assertEquals(Person.RoleType.STUDENT, s.getRole());
    }

    @Test
    public void testSetUsername() {
        Student s = new Student();
        s.setUsername("peldapeter99");
        assertEquals("peldapeter99", s.getUsername());
    }

    @Test
    public void testSetPassword() {
        Student s = new Student();
        s.setPassword("alma123");
        assertEquals("alma123", s.getPassword());
    }

}