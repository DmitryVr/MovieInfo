package movie.info.service.impl;

import movie.info.dao.interfaces.RoleDao;
import movie.info.dao.interfaces.UserDao;
import movie.info.model.impl.Role;
import movie.info.model.impl.User;
import movie.info.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDaoImpl;

    @Autowired
    private RoleDao roleDaoImpl;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void add(User model) {
        model.setPassword(bCryptPasswordEncoder.encode(model.getPassword())); // хешировать пароль
        Set<Role> roles = new HashSet<>();
        roles.add(roleDaoImpl.getById(1L)); // давать всем роль ROLE_USER
        model.setRoles(roles); // установить юзеру роль

        userDaoImpl.add(model);
    }

    /**
     * метод для валидатора UserValidator
     */
    @Override
    @Transactional
    public User getByUsername(String username) {
        User user = userDaoImpl.getByUsername(username);

        return user;
    }
}
