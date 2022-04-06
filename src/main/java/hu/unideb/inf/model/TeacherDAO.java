package hu.unideb.inf.model;

import java.util.List;

public interface TeacherDAO extends AutoCloseable{
    public void saveTeacher(Teacher teacher);
    public void deleteTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public List<Teacher> getTeachers();
}
