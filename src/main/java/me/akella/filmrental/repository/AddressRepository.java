package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Address;

@ApplicationScoped
public class AddressRepository
        implements PanacheRepositoryBase<Address, Integer> {

}
