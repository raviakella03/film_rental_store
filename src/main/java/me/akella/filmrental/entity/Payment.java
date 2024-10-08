package me.akella.filmrental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "payment", schema = "sakila")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", columnDefinition = "smallint unsigned")
    private Integer id;

    @Column(name = "amount", columnDefinition = "decimal(5,2)")
    private Float amount;

    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer paidBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff paymentReceivedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental paidFor;

    @PrePersist
    public void preCreate() {
        Timestamp now = Timestamp.from(Instant.now());
        setPaymentDate(now);
        setLastUpdated(now);
    }

    @PreUpdate
    public void preUpdate() {
        setLastUpdated(Timestamp.from(Instant.now()));
    }
}