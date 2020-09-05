package cr.una.taskapp.backend.service;

import cr.una.taskapp.backend.model.Priority;

import java.util.List;

/**
 * PriorityService
 *
 * The Service for Priority
 */
public interface IPriorityService {
    /**
     * Find priority by id
     * @param id identification of the priority
     * @return the priority found
     */
    public Priority findById (final long id);

    /**
     * Method to find all entities
     * @return the list of entities of Priority
     */
    public List<Priority> findAll();

    /**
     * Method to create a new entity
     * @param priority the entity to create in the database
     * @return the priority created with the corresponding id
     */
    public Priority create (final Priority priority);

    /**
     * Method to update the entity in the database
     * @param priority the entity with new information to update
     * @return the updated priority
     */
    public Priority update (final Priority priority);

    /**
     * Method to delete a entity in the database
     * @param priority the entity to deleted
     */
    public void delete (final Priority priority);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id);
}
