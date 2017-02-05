package movie.info.dao.interfaces;

import movie.info.model.impl.Movie;

import java.util.List;

public interface MovieDao extends ItemDao<Movie> {
    List<Movie> getByName(String subString);
}
