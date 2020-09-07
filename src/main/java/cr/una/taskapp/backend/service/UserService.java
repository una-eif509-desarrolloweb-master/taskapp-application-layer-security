package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IRoleDao;
import cr.una.taskapp.backend.dao.IUserDao;
import cr.una.taskapp.backend.model.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao dao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Method to find the entity by id
     *
     * @param id the id of the entity to find
     * @return the corresponding UserDao
     */
    @Override
    public User findById(long id) {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of UserDao
     */
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param user the entity to create in the database
     * @return the user created with the corresponding id
     */
    @Override
    public User create(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getCreateDate() == null) {
            DateTime dt = new DateTime();
            user.setCreateDate(dt.toDate());
        }
        user.setEnabled(true);
        user.setRoleList(Collections.singletonList(roleDao.findByName("ROLE_USER")));

        return dao.create(user);
    }

    /**
     * Method to update the entity in the database
     *
     * @param user the entity with new information to update
     * @return the updated user
     */
    @Override
    public User update(User user) {
        return dao.update(user);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param user the entity to deleted
     */
    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
