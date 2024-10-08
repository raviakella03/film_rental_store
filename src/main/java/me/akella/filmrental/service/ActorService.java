package me.akella.filmrental.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import me.akella.filmrental.entity.Actor;
import me.akella.filmrental.entity.Film;
import me.akella.filmrental.repository.ActorRepository;
import me.akella.filmrental.repository.FilmRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Singleton
public class ActorService {

    ActorRepository actorRepository;
    FilmRepository filmRepository;

    @Inject
    public ActorService(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    @Transactional
    public List<Actor> getAllActors() {
        return actorRepository.listAll();
    }

    @Transactional
    public boolean saveNewActor(Actor newActor) {
        try {
            Film film = filmRepository.findById(1);
            Set<Film> films = newActor.getFilmsActed();
            if (null == films) {
                films = new HashSet<>();
            }
            films.add(film);

            newActor.setFilmsActed(films);
            actorRepository.persist(newActor);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    public Actor findActorById(Integer id) {
        return actorRepository.findById(id);
    }
}
