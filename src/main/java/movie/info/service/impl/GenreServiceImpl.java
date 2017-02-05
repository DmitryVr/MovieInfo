package movie.info.service.impl;

import movie.info.dao.interfaces.GenreDao;
import movie.info.model.impl.Genre;
import movie.info.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDao genreDaoDatabase;

    @Override
    @Transactional
    public List<Genre> getAll() {
        return genreDaoDatabase.getAll();
    }

    @Override
    @Transactional
    public Genre getById(long id) {
        return genreDaoDatabase.getById(id);
    }
}
