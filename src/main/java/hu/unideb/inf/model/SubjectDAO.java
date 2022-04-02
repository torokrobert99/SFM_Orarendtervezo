package hu.unideb.inf.model;

import java.util.List;

public interface SubjectDAO {
    public void saveSubject(Subject a);
    public void deleteSubject(Subject a);
    public void updateSubject(Subject a);
    public List<Subject> getSubjects();
}
