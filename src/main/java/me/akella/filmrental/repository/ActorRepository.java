package me.akella.filmrental.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.akella.filmrental.entity.Actor;

@ApplicationScoped
public class ActorRepository
        implements PanacheRepositoryBase<Actor, Integer> {

}
