package movie.info.dao.impl;

import movie.info.dao.interfaces.MovieDao;
import movie.info.model.impl.Movie;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class MovieDaoDatabase implements MovieDao {
    private static final Logger log = Logger.getLogger(MovieDaoDatabase.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Movie getById(long id) {
        log.info("Get movie by id");
        Session session = this.sessionFactory.getCurrentSession();
        Movie movie = session.get(Movie.class, id);

        return movie;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Movie> getByName(String subString) {
        log.info("Get movie by substring: " + subString);
        Session session = this.sessionFactory.getCurrentSession();
        List<Movie> movieList = session.createQuery("FROM Movie WHERE nameOriginal LIKE '%" + subString + "%' OR nameRussian LIKE '%" + subString + "%'").list();

        return movieList;
    }

    @Override
    public void delete(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Movie movie = (Movie) session.get(Movie.class, id);

        if(movie != null){
            session.delete(movie);
        }
    }

    @Override
    public void add(Movie model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Movie model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Movie> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Movie> movieList = session.createQuery("FROM Movie").list();

        return movieList;
    }
}
