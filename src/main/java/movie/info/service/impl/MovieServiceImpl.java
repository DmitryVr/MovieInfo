package movie.info.service.impl;

import movie.info.dao.interfaces.MovieDao;
import movie.info.model.impl.Movie;
import movie.info.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDaoDatabase;

    @Override
    @Transactional
    public Movie getById(long id) {
        return movieDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public List<Movie> getByName(String subString) {
        return movieDaoDatabase.getByName(subString);
    }

    @Override
    @Transactional
    public void add(Movie model) {
        movieDaoDatabase.add(model);
    }

    @Override
    @Transactional
    public void update(Movie model) {
        movieDaoDatabase.update(model);
    }

    @Override
    @Transactional
    public void delete(long id) {
        movieDaoDatabase.delete(id);
    }

    @Override
    @Transactional
    public List<Movie> getAll() {
        return movieDaoDatabase.getAll();
    }
}
