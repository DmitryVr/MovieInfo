package movie.info.dao.interfaces;

import movie.info.model.abstracts.Model;

import java.util.List;

public interface ItemDao<T extends Model> {
    default List<T> getAll() {
        return null;
    }

    default T getById(long id) {
        return null;
    }

    default void add(T model) {
    }

    default void update(T model) {
    }

    default void delete(long id) {
    }
}