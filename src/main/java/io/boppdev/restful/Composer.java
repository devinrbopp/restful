package io.boppdev.restful;

import javax.persistence.*;

@Entity
@Table(name="composers")
public class Composer {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    public String lastname;

    public Composer(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getId() {
        return id;
    }
}
