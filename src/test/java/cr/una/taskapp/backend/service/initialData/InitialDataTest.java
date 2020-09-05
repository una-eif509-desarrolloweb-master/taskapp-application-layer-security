/*
 *
 *  *
 *  *
 *  * Universidad Nacional de Costa Rica  2020
 *  *
 *  * mike@guzmanalan.com
 *  *
 *  *
 *
 *
 */

package cr.una.taskapp.backend.service.initialData;

import cr.una.taskapp.backend.model.Priority;
import cr.una.taskapp.backend.service.IPriorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to import initial data to database
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({
        "/import-initialdata.sql"
})
public class InitialDataTest {

    @Autowired
    private IPriorityService priorityService;

    @Test
    public void loadPriorities() {
        List<Priority> priorityList = priorityService.findAll();

        assertTrue(priorityList.size() == 3);
    }
}
