package cr.una.taskapp.backend.service.dao;


import cr.una.taskapp.backend.dao.IPriorityDao;
import cr.una.taskapp.backend.model.Priority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit Test Class
 * Priority DAO
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-priorities.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-priorities.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class PriorityDaoTest {

    @Autowired
    private IPriorityDao priorityDao;

    @Test
    public void testFindById() {
        Priority priority = priorityDao.findById(2);

        assertEquals(priority.getLabel(), "Medium");
    }

    @Test
    public void testFindAll() {
        List<Priority> priorityList = priorityDao.findAll();

        assertTrue(priorityList.size() == 3);
    }

    @Test
    public void testCreate() {
        Priority priority = new Priority();

        priority.setIdPriority(4L);
        priority.setLabel("Trivial");

        priorityDao.create(priority);

        assertEquals(priority.getIdPriority(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() {
        Priority priorityUpdated = new Priority();

        priorityUpdated.setIdPriority(2L);
        priorityUpdated.setLabel("Medium - Updated");

        priorityDao.update(priorityUpdated);

        Priority priority = priorityDao.findById(2);
        assertEquals(priority.getLabel().toString(), "Medium - Updated");
    }

    @Test
    public void testDelete() {
        Priority priorityDeleted = new Priority();
        priorityDeleted.setIdPriority(1L);

        priorityDao.delete(priorityDeleted);

        Priority priority = priorityDao.findById(1);
        assertTrue(priority == null);
    }

    @Test
    public void testDeleteById() {
        priorityDao.deleteById(1L);

        Priority priority = priorityDao.findById(1);
        assertTrue(priority == null);
    }
}
