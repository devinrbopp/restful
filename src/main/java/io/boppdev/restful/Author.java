package io.boppdev.restful;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    public Author() {};

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    public String last_name;
    public String first_name;

    public Author(String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }
}
