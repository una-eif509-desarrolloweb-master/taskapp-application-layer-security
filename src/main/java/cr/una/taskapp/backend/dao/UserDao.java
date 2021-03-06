package cr.una.taskapp.backend.dao;

import com.google.common.base.Preconditions;
import cr.una.taskapp.backend.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * DAO User
 */
@Repository
public class UserDao extends AbstractHibernateDao implements IUserDao {
    /**
     * Method to find the entity by id
     *
     * @param id the id of the entity to find
     * @return the corresponding UserDao
     */
    @Override
    public User findById(long id) {
        return getCurrentSession().get(User.class, id);
    }

    /**
     * Method to find the entity by email
     *
     * @param email the email of the entity to find
     * @return the corresponding UserDao
     */
    @Override
    public User findByEmail(String email) {
        Query query = getCurrentSession().createQuery("from User u where u.email = :email");
        query.setParameter("email", email);

        return (User) query.getResultList().get(0);
    }

    /**
     * Method to find the entity by email
     *
     * @param username the username of the entity to find
     * @return the corresponding UserDao
     */
    @Override
    public User findByUsername(String username) {
        User user = null;
        Query query = getCurrentSession().createQuery("from User u where u.username = :username");
        query.setParameter("username", username);
        if (query.getResultList().size()>0) {
            user = (User) query.getResultList().get(0);
        }

        return user;
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of UserDao
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return getCurrentSession().createQuery("from User").getResultList();
    }

    /**
     * Method to create a new entity
     *
     * @param user the entity to create in the database
     * @return the user created with the corresponding id
     */
    @Override
    public User create(User user) {
        Preconditions.checkNotNull(user);
        getCurrentSession().saveOrUpdate(user);

        return user;
    }

    /**
     * Method to update the entity in the database
     *
     * @param user the entity with new information to update
     * @return the updated user
     */
    @Override
    public User update(User user) {
        Preconditions.checkNotNull(user);
        return (User) getCurrentSession().merge(user);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param user the entity to deleted
     */
    @Override
    public void delete(User user) {
        Preconditions.checkNotNull(user);
        getCurrentSession().delete(user);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) {
        final User user = findById(id);
        Preconditions.checkState(user != null);
        delete(user);
    }
}
