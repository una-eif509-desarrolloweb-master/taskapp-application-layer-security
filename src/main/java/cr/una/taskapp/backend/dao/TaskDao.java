/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

package cr.una.taskapp.backend.dao;

import com.google.common.base.Preconditions;
import cr.una.taskapp.backend.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO Task
 */
@Repository
public class TaskDao extends AbstractHibernateDao implements ITaskDao {

    /**
     * Method to find the entity by id
     *
     * @param id the id of the entity to find
     * @return the corresponding task
     */
    @Override
    public Task findById(long id) {
        return getCurrentSession().get(Task.class, id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Task
     */
    @Override
    public List<Task> findAll() {
        return getCurrentSession().createQuery("from Task").getResultList();
    }

    /**
     * Method to create a new entity
     *
     * @param task the entity to create in the database
     * @return the task created with the corresponding id
     */
    @Override
    public Task create(Task task) {
        Preconditions.checkNotNull(task);
        getCurrentSession().saveOrUpdate(task);
        return task;
    }

    /**
     * Method to update the entity in the database
     *
     * @param task the entity with new information to update
     * @return the updated task
     */
    @Override
    public Task update(Task task) {
        Preconditions.checkNotNull(task);
        return (Task) getCurrentSession().merge(task);    }

    /**
     * Method to delete a entity in the database
     *
     * @param task the entity to deleted
     */
    @Override
    public void delete(Task task) {
        Preconditions.checkNotNull(task);
        getCurrentSession().delete(task);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) {
        final Task task = findById(id);
        Preconditions.checkState(task != null);
        delete(task);
    }
}
