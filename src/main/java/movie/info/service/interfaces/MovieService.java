package movie.info.service.interfaces;

import movie.info.model.impl.Movie;

import java.util.List;

public interface MovieService extends ItemService<Movie> {
    List<Movie> getByName(String subString);
}
