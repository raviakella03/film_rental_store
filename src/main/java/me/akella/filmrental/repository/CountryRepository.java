package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Country;

@ApplicationScoped
public class CountryRepository
        implements PanacheRepositoryBase<Country, Integer> {

}
