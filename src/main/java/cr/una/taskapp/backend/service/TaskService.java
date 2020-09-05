package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.dao.IPriorityDao;
import cr.una.taskapp.backend.model.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * TaskService
 *
 * The Service for Task
 */
public class TaskService implements ITaskService{

    @Autowired
    private ITaskService dao;

    /**
     * Method to find the entity by id
     *
     * @param id the id of the entity to find
     * @return the corresponding task
     */
    @Override
    public Task findById(long id) {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Task
     */
    @Override
    public List<Task> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param task the entity to create in the database
     * @return the task created with the corresponding id
     */
    @Override
    public Task create(Task task) {
        return dao.create(task);
    }

    /**
     * Method to update the entity in the database
     *
     * @param task the entity with new information to update
     * @return the updated task
     */
    @Override
    public Task update(Task task) {
        return dao.update(task);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param task the entity to deleted
     */
    @Override
    public void delete(Task task) {
        dao.delete(task);
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
