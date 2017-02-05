package movie.info.service.interfaces;

import movie.info.model.impl.User;

public interface UserService extends ItemService<User> {
    User getByUsername(String username);
}
