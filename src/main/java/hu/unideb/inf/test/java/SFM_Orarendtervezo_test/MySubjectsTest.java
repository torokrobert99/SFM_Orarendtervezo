package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.MySubjects;


public class MySubjectsTest {

    @Test
    public void testsetId() {
        MySubjects s = new MySubjects();
        s.setId(1);
        assertEquals(1, s.getId());
    }

    @Test
    public void testgetSubject() {
        MySubjects s = new MySubjects();
        s.setSubject("alma");
        assertEquals("alma", s.getSubject());
    }

    @Test
    void setStudent_id() {
        MySubjects s = new MySubjects();
        s.setStudent_id(1);
        assertEquals(1, s.getStudent_id());
    }

    @Test
    void setNap() {
        MySubjects s = new MySubjects();
        s.setNap("Hétfő");
        assertEquals("Hétfő", s.getNap());
    }

    @Test
    void setOra() {
        MySubjects s = new MySubjects();
        s.setOra("Matmérnök");
        assertEquals("Matmérnök", s.getOra());
    }
}
