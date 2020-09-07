package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Role;

/**
 * DAO Role
 */
public interface IRoleDao {
    /**
     * Method to find the entity by id
     * @param name the name of the entity to find
     * @return the corresponding task
     */
    public Role findByName (final String name);
}
