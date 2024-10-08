package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Store;

@ApplicationScoped
public class StoreRepository
        implements PanacheRepositoryBase<Store, Integer> {

}
