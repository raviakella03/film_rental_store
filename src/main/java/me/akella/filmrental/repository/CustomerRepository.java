package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Customer;

@ApplicationScoped
public class CustomerRepository
        implements PanacheRepositoryBase<Customer, Integer> {

}
