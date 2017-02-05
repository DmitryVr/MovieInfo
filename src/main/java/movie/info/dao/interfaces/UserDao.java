package movie.info.dao.interfaces;

import movie.info.model.impl.User;

public interface UserDao extends ItemDao<User> {
    User getByUsername(String username);
}