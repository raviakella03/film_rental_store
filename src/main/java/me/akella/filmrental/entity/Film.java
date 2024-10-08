package me.akella.filmrental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.akella.filmrental.entity.converter.SpecialFeatureStringSetConverter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Year;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "film", schema = "sakila")
public class Film
        extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "smallint unsigned")
    private Integer id;

    @Column(name = "title", columnDefinition = "varchar(128)")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year", columnDefinition = "year")
    private Year releaseYear;

    @Column(name = "rental_duration", columnDefinition = "tinyint unsigned")
    @ColumnDefault(value = "3")
    private Integer rentalDuration;

    @Column(name = "rental_rate", columnDefinition = "decimal(4,2)")
    @ColumnDefault(value = "4.99")
    private Float rentalRate;

    @Column(name = "length", columnDefinition = "smallint unsigned")
    private Integer runtime;

    @Column(name = "replacement_cost", columnDefinition = "decimal(5,2)")
    @ColumnDefault(value = "19.99")
    private Float replacementCost;

    @Column(name = "rating", columnDefinition = "enum")
    @ColumnDefault("'G'")
    private String filmRating;

    @Column(name = "special_features", columnDefinition = "set")
    @Convert(converter = SpecialFeatureStringSetConverter.class)
    private Set<String> specialFeatures;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_category",
               joinColumns = {@JoinColumn(name = "film_id")},
               inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_actor",
               joinColumns = {@JoinColumn(name = "film_id")},
               inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private Set<Actor> cast;

    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private Set<Inventory> inventories;
}