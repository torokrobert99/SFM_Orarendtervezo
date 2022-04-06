package hu.unideb.inf.model;

import java.util.List;

public interface StudentDAO extends AutoCloseable{
    public void saveStudent(Student student);
    public void deleteStudent(Student student);
    public void updateStudent(Student student);
    public List<Student> getStudents();
}
