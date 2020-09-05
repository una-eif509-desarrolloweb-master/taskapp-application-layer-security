package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IPriorityDao;
import cr.una.taskapp.backend.model.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PriorityService
 *
 * The Service for Priority
 */
@Service
@Transactional
public class PriorityService implements IPriorityService {

    @Autowired
    private IPriorityDao dao;

    /**
     * Find priority by id
     *
     * @param id identification of the priority
     * @return the priority found
     */
    @Override
    public Priority findById(long id) {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Priority
     */
    @Override
    public List<Priority> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param priority the entity to create in the database
     * @return the priority created with the corresponding id
     */
    @Override
    public Priority create(Priority priority) {
        return dao.create(priority);
    }

    /**
     * Method to update the entity in the database
     *
     * @param priority the entity with new information to update
     * @return the updated priority
     */
    @Override
    public Priority update(Priority priority) {
        return dao.update(priority);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param priority the entity to deleted
     */
    @Override
    public void delete(Priority priority) {
        dao.delete(priority);
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
