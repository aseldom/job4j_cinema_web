package ru.job4j.cinemaweb.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinemaweb.model.Genre;

import java.util.Collection;

@Repository
public class Sql2oGenreRepository implements GenreRepository {

    private final Sql2o sql2o;

    public Sql2oGenreRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Genre findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres WHERE id = :id", true)
                    .addParameter("id", id);
            return query.executeAndFetchFirst(Genre.class);
        }
    }

    @Override
    public Collection<Genre> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres");
            return query.executeAndFetch(Genre.class);
        }
    }
}
