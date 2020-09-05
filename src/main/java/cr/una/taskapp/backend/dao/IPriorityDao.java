package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Priority;

import java.util.List;

/**
 * DAO Priority
 */
public interface IPriorityDao {
    public Priority findById (final long id);
    public List<Priority> findAll();
    public Priority create (final Priority priority);
    public Priority update (final Priority priority);
    public void delete (final Priority priority);
    public void deleteById (final long id);
}
