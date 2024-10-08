package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Category;

@ApplicationScoped
public class CategoryRepository
        implements PanacheRepositoryBase<Category, Integer> {

}
