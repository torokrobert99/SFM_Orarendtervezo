package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.Teacher;
import hu.unideb.inf.model.Person;

public class TestTeacher {

    @Test
    public void testTeacher() {
        Teacher t = new Teacher();
        t.setName("Példa Péter");
        t.setAge(21);
        t.setRole(Person.RoleType.TEACHER);
        t.setUsername("peldapeter99");
        t.setPassword("alma123");
        assertEquals("Példa Péter", t.getName());
        assertEquals(21, t.getAge());
        assertEquals(Person.RoleType.TEACHER, t.getRole());
        assertEquals("peldapeter99", t.getUsername());
        assertEquals("alma123", t.getPassword());
    }

    @Test
    public void testSetName() {
        Teacher t = new Teacher();
        t.setName("Példa Péter");
        assertEquals("Példa Péter", t.getName());
    }

    @Test
    public void testSetAge() {
        Teacher t = new Teacher();
        t.setAge(21);
        assertEquals(21, t.getAge());
    }

    @Test
    public void testSetRole() {
        Teacher t = new Teacher();
        t.setRole(Person.RoleType.TEACHER);
        assertEquals(Person.RoleType.TEACHER, t.getRole());
    }

    @Test
    public void testSetUsername() {
        Teacher t = new Teacher();
        t.setUsername("peldapeter99");
        assertEquals("peldapeter99", t.getUsername());
    }

    @Test
    public void testSetPassword() {
        Teacher t = new Teacher();
        t.setPassword("alma123");
        assertEquals("alma123", t.getPassword());
    }
}
