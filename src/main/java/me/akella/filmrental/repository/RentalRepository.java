package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Rental;

@ApplicationScoped
public class RentalRepository
        implements PanacheRepositoryBase<Rental, Integer> {

}
