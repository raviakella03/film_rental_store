package me.akella.filmrental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer", schema = "sakila")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "smallint unsigned")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String emailId;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "rentedBy", fetch = FetchType.LAZY)
    private Set<Rental> rentals;

    @OneToMany(mappedBy = "paidBy", fetch = FetchType.LAZY)
    private Set<Payment> payments;

    @PrePersist
    public void preCreate() {
        Timestamp now = Timestamp.from(Instant.now());
        setCreatedDate(now);
        setLastUpdated(now);
    }

    @PreUpdate
    public void preUpdate() {
        setLastUpdated(Timestamp.from(Instant.now()));
    }
}