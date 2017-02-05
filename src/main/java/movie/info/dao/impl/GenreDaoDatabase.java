package movie.info.dao.impl;

import movie.info.dao.interfaces.GenreDao;
import movie.info.model.impl.Genre;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoDatabase implements GenreDao {
    private static final Logger log = Logger.getLogger(GenreDaoDatabase.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> getAll() {
        log.info("Get all genres");
        Session session = this.sessionFactory.getCurrentSession();
        List<Genre> genreList = session.createQuery("FROM Genre").list();

        return genreList;
    }

    @Override
    public Genre getById(long id) {
        log.info("Get genre by id");
        Session session = this.sessionFactory.getCurrentSession();
        Genre genre = session.get(Genre.class, id);

        return genre;
    }
}
