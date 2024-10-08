package me.akella.filmrental.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "store", schema = "sakila")
public class Store
        extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "tinyint unsigned")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id")
    private Staff manager;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address storeAddress;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private Set<Staff> staff;

    @OneToMany(mappedBy = "availableAt", fetch = FetchType.LAZY)
    private Set<Inventory> inventories;
}