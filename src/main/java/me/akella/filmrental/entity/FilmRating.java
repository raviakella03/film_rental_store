package me.akella.filmrental.entity;

import lombok.Getter;

@Getter
public enum FilmRating {
    G("G"), PG("PG"), PG13("PG-13"), R("R"), NC17("NC-17");

    private final String value;

    private FilmRating(String value) {
        this.value = value;
    }

}
