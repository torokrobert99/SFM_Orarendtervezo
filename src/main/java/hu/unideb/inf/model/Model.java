package hu.unideb.inf.model;

public class Model {
    private Person person;
    private Student student;
    private Teacher teacher;

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Person getPerson() {

        return person;
    }
    public Model(Person p)
    {
        this.person = new Person();
    }
    public Model(Student s) {this.student = new Student(); }
    public Model(Teacher t) {this.teacher = new Teacher(); }
}
