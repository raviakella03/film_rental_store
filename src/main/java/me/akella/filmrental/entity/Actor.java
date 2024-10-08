package me.akella.filmrental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actor", schema = "sakila")
public class Actor
        extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", columnDefinition = "smallint unsigned")
    private Integer id;

    @Column(name = "first_name", columnDefinition = "varchar(45)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(45)")
    private String lastName;

    @ManyToMany(mappedBy = "cast", fetch = FetchType.LAZY)
    private Set<Film> filmsActed;
}