package movie.info.dao.impl;

import movie.info.dao.interfaces.RoleDao;
import movie.info.model.impl.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoDatabase implements RoleDao {
    private static final Logger log = Logger.getLogger(RoleDaoDatabase.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getById(long id) {
        log.info("Get role by id");
        Session session = this.sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, id);

        return role;
    }
}
