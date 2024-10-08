package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Language;


@ApplicationScoped
public class LanguageRepository
        implements PanacheRepositoryBase<Language, Integer> {

}
