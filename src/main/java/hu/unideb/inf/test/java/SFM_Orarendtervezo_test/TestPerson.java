package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.Person;
import hu.unideb.inf.model.Teacher;
import hu.unideb.inf.model.Student;


public class TestPerson {

    @Test
    public void testSetName() {
        Person p = new Person();
        p.setName("Példa Péter");
        assertEquals("Példa Péter", p.getName());
    }

    @Test
    public void testSetAge() {
        Person p = new Person();
        p.setAge(21);
        assertEquals(21, p.getAge());
    }

    @Test
    public void testSetRole() {
        Person p = new Person();
        p.setRole(Person.RoleType.STUDENT);
        assertEquals(Person.RoleType.STUDENT, p.getRole());
    }

    @Test
    public void testSetId() {
        Person p = new Person();
        p.setId(1);
        assertEquals(1, p.getId());
    }

    @Test
    public void testSetRoleType() {
        Person p = new Person();
        p.setRole(Person.RoleType.STUDENT);
        assertEquals(Person.RoleType.STUDENT, p.getRole());
    }

    @Test
    public void testSetRoleType2() {
        Person p = new Person();
        p.setRole(Person.RoleType.TEACHER);
        assertEquals(Person.RoleType.TEACHER, p.getRole());
    }
}
