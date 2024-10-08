package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Inventory;

@ApplicationScoped
public class InventoryRepository
        implements PanacheRepositoryBase<Inventory, Integer> {

}
