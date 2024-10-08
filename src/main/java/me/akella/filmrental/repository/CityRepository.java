package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.City;

@ApplicationScoped
public class CityRepository
        implements PanacheRepositoryBase<City, Integer> {

}
