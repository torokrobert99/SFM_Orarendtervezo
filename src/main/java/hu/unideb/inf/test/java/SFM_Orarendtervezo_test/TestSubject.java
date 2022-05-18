package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.SubjectGroups;

public class TestSubject {

    @Test
    public void testgetGroups() {
        Subject s = new Subject();
        s.setGroups(new SubjectGroups());
        assertEquals(new SubjectGroups(), s.getGroups());
    }

    @Test
    public void testgetTargyfelelos() {
        Subject s = new Subject();
        s.setTargyfelelos("alma");
        assertEquals("alma", s.getTargyfelelos());
    }

    @Test
    public void testgetId() {
        Subject s = new Subject();
        s.setId(1);
        assertEquals(1, s.getId());
    }

    @Test
    public void testgetSubjectName() {
        Subject s = new Subject();
        s.setSubjectName("alma");
        assertEquals("alma", s.getSubjectName());
    }

    @Test
    public void testgetCredit() {
        Subject s = new Subject();
        s.setCredit(1);
        assertEquals(1, s.getCredit());
    }
}
