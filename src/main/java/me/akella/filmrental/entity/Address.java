package me.akella.filmrental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Geometry;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "sakila")
public class Address
        extends BaseEntity {

    @Id
    @Column(name = "address_id", columnDefinition = "smallint unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address", columnDefinition = "varchar(50)")
    private String addressLine1;

    @Column(name = "address2", columnDefinition = "varchar(50)")
    private String addressLine2;

    @Column(name = "district", columnDefinition = "varchar(20)")
    private String district;

    @Column(name = "postal_code", columnDefinition = "varchar(10)")
    private String postalCode;

    @Column(name = "phone", columnDefinition = "varchar(20)")
    private String phoneNumber;

    @Column(name = "location", columnDefinition = "geometry")
    private Geometry location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Customer> customers;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Staff> staff;
}