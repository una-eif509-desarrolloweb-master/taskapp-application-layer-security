/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

package cr.una.taskapp.backend.service.dao;

import cr.una.taskapp.backend.dao.IPriorityDao;
import cr.una.taskapp.backend.dao.ITaskDao;
import cr.una.taskapp.backend.model.Status;
import cr.una.taskapp.backend.model.Task;
import cr.una.taskapp.backend.model.User;
import org.joda.time.DateTime;
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
 * Task DAO
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-users.sql",
        "/import-priorities.sql",
        "/import-status.sql",
        "/import-tasks.sql",
        "/import-reminders.sql"
})
public class TaskDaoTest {

    @Autowired
    private ITaskDao taskDao;

    @Autowired
    private IPriorityDao priorityDao;

    @Test
    public void testFindById() {
        Task task = taskDao.findById(1);

        assertEquals(task.getTitle().toString(), "Evaluate Students");
    }

    @Test
    public void testFindAll() {
        List<Task> taskList = taskDao.findAll();

        assertTrue(taskList.size() == 2);
    }

    @Test
    public void testCreate() {
        DateTime dt = new DateTime();
        Task task = new Task();
        Status status = new Status();
        User user = new User();

        user.setIdUser(1L);

        status.setIdStatus(1L);

        task.setIdTask(3L);
        task.setTitle("Test Task");
        task.setNotes("Some notes");
        task.setCreateDate(dt.toDate());
        task.setDueDate(dt.toDate());
        task.setUser(user);

        task.setPriority(priorityDao.findById(1));
        task.setStatus(status);

        taskDao.create(task);

        assertEquals(task.getIdTask(), Long.valueOf(3));
    }

    @Test
    public void testUpdate() {
        DateTime dt = new DateTime();
        Task task = taskDao.findById(1);

        task.setTitle("Test Update");

        taskDao.update(task);
        assertEquals(task.getTitle().toString(), "Test Update");
    }

    @Test
    public void testDelete() {
        Task task = taskDao.findById(2);

        taskDao.delete(task);

        task = taskDao.findById(2);
        assertTrue(task == null);
    }

    @Test
    public void testDeleteById() {
        taskDao.deleteById(2L);

        Task task = taskDao.findById(2);
        assertTrue(task == null);
    }
}
