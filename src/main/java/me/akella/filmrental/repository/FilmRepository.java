package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Film;

@ApplicationScoped
public class FilmRepository
        implements PanacheRepositoryBase<Film, Integer> {

}
