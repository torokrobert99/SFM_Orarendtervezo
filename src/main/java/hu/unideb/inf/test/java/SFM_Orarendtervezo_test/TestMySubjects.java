package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.MySubjects;


public class TestMySubjects {

    @Test
    public void testgetId() {
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
}
