package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubjectGroups {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Subject subject;
    private String oktato;
    private String nap;
    private int idopont;

    public String getOktato() {
        return oktato;
    }

    public void setOktato(String oktato) {
        this.oktato = oktato;
    }

    public String getNap() {
        return nap;
    }

    public void setNap(String nap) {
        this.nap = nap;
    }

    public int getIdopont() {
        return idopont;
    }

    public void setIdopont(int idopont) {
        this.idopont = idopont;
    }

    public Subject getSubject() {return subject;}

    public void setSubject(Subject subject) {this.subject = subject;}




}
