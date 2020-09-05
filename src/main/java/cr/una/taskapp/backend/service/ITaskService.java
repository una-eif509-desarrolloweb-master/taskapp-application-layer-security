package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.model.Task;

import java.util.List;

/**
 * ITaskService
 *
 * The Service for Task
 */
public interface ITaskService {
    /**
     * Method to find the entity by id
     * @param id the id of the entity to find
     * @return the corresponding task
     */
    public Task findById (final long id);

    /**
     * Method to find all entities
     * @return the list of entities of Task
     */
    public List<Task> findAll();

    /**
     * Method to create a new entity
     * @param task the entity to create in the database
     * @return the task created with the corresponding id
     */
    public Task create (final Task task);

    /**
     * Method to update the entity in the database
     * @param task the entity with new information to update
     * @return the updated task
     */
    public Task update (final Task task);

    /**
     * Method to delete a entity in the database
     * @param task the entity to deleted
     */
    public void delete (final Task task);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id);
}
