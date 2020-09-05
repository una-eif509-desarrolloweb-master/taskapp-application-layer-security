package cr.una.taskapp.backend.dao;

import com.google.common.base.Preconditions;
import cr.una.taskapp.backend.model.Priority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO Priority
 */
@Repository
public class PriorityDao extends AbstractHibernateDao implements IPriorityDao {

    @Override
    public Priority findById(final long id) { return getCurrentSession().get(Priority.class, id); }

    @Override
    @SuppressWarnings("unchecked")
    public List<Priority> findAll() {
        return getCurrentSession().createQuery("from Priority").getResultList();
    }

    @Override
    public Priority create(Priority priority) {
        Preconditions.checkNotNull(priority);
        getCurrentSession().saveOrUpdate(priority);

        return priority;
    }

    @Override
    public Priority update(Priority priority) {
        Preconditions.checkNotNull(priority);
        return (Priority) getCurrentSession().merge(priority);
    }

    @Override
    public void delete(Priority priority) {
        Preconditions.checkNotNull(priority);
        getCurrentSession().delete(priority);
    }

    @Override
    public void deleteById(long id) {
        final Priority priority = findById(id);
        Preconditions.checkState(priority != null);
        delete(priority);
    }

}
