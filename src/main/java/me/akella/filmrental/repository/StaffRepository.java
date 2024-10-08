package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Staff;

@ApplicationScoped
public class StaffRepository
        implements PanacheRepositoryBase<Staff, Integer> {

}
