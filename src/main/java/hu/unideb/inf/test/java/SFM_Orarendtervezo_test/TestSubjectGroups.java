package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hu.unideb.inf.model.SubjectGroups;


public class TestSubjectGroups {

    @Test
    public void testgetOktato() {
        SubjectGroups s = new SubjectGroups();
        s.setOktato("Pelda Peter");
        assertEquals("Pelda Peter", s.getOktato());
    }

    @Test
    public void testgetNap() {
        SubjectGroups s = new SubjectGroups();
        s.setNap("kedd");
        assertEquals("kedd", s.getNap());
    }


    @Test
    public void testgetIdopont() {
        SubjectGroups s = new SubjectGroups();
        s.setIdopont(1000);
        assertEquals(1000, s.getIdopont());
    }
}
