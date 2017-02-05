package movie.info.dao.impl;

import movie.info.dao.interfaces.UserDao;
import movie.info.model.impl.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoDatabase implements UserDao {
    private static final Logger log = Logger.getLogger(UserDaoDatabase.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public User getByUsername(String username) {
        log.info("Get user by username");
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User u WHERE u.username=:username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();

        return user;
    }

    @Override
    public void add(User model) {
        log.info("Add new user");
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }
}
