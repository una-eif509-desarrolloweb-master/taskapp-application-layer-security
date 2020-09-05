package cr.una.taskapp.backend.service.service;

import cr.una.taskapp.backend.dao.IPriorityDao;
import cr.una.taskapp.backend.model.Priority;
import cr.una.taskapp.backend.model.Task;
import cr.una.taskapp.backend.service.PriorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PriorityServiceTest {

    @InjectMocks
    private PriorityService priorityService;

    @Mock
    private IPriorityDao priorityDao;

    @Test
    public void testFindById() {
        // given
        final Long id = 1l;
        Task task = new Task();
        Priority priority = new Priority();
        Priority priorityExpected;

        task.setIdTask(id);
        task.setTitle("Test");

        priority.setIdPriority(id);
        priority.setLabel("Medium");
        priority.setTaskList(Arrays.asList(task));

        given(priorityDao.findById(id)).willReturn(priority);

        // when
        priorityExpected = priorityService.findById(id);

        // then
        assertThat(priorityExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Task task = new Task();
        Priority priority = new Priority();

        task.setIdTask(id);
        task.setTitle("Test");

        priority.setIdPriority(id);
        priority.setLabel("Medium");
        priority.setTaskList(Arrays.asList(task));

        List<Priority> priorityList = Arrays.asList(priority);

        given(priorityDao.findAll()).willReturn(priorityList);

        // when
        List<Priority> priorityListExpected = priorityService.findAll();

        // then
        assertThat(priorityList).isEqualTo(priorityListExpected);
    }

    @Test
    public void testCreatePriority() {
        // given
        final Long id = 1l;
        Task task = new Task();
        Priority priority = new Priority();

        task.setIdTask(id);
        task.setTitle("Test");

        priority.setIdPriority(id);
        priority.setLabel("Medium");
        priority.setTaskList(Arrays.asList(task));

        given(priorityDao.create(priority)).willReturn(priority);

        // when
        Priority priorityCreated = priorityService.create(priority);

        // then
        assertThat(priorityCreated).isNotNull();
    }

    @Test
    public void testUpdatePriority() {
        // given
        final Long id = 1l;
        Task task = new Task();
        Priority priority = new Priority();

        task.setIdTask(id);
        task.setTitle("Test");

        priority.setIdPriority(id);
        priority.setLabel("Medium");
        priority.setTaskList(Arrays.asList(task));

        given(priorityDao.update(priority)).willReturn(priority);

        // when
        Priority priorityUpdated = priorityService.update(priority);

        // then
        assertThat(priorityUpdated).isNotNull();
    }

}
