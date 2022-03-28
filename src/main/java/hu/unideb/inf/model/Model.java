package hu.unideb.inf.model;

public class Model {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public Model()
    {
        this.person = new Person("","");
    }
}
