package hu.unideb.inf.model;

import java.util.List;

public interface MySubjectsDAO extends AutoCloseable{
    public void saveMySubjects(MySubjects a);
    public void deleteMySubjects(MySubjects a);
    public void updateMySubjects(MySubjects a);
    public List<MySubjects> getMySubjects();
}
