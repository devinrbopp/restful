package io.boppdev.restful;

import javax.persistence.*;

@Entity
@Table(name="composers")
public class Composer {
    public Composer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    public String firstname;

    public String lastname;

    public Composer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName() {
        return String.format("%s, %s", lastname, firstname);
    }

    public Composer setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Integer getId() {
        return id;
    }
}
