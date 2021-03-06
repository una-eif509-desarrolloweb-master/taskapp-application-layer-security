package cr.una.taskapp.backend.dao;

import cr.una.taskapp.backend.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * DAO Role
 */
@Repository
public class RoleDao extends AbstractHibernateDao implements IRoleDao {

    /**
     * Method to find the entity by id
     *
     * @param name the name of the entity to find
     * @return the corresponding task
     */
    @Override
    public Role findByName(String name) {
        Role role = null;
        Query query = getCurrentSession().createQuery("from Role r where r.name = :name");
        query.setParameter("name", name);

        if (query.getResultList().size() > 0) {
            role = (Role) query.getResultList().get(0);
        }

        return role;
    }
}
