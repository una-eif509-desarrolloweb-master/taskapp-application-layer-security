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

package cr.una.taskapp.backend.dto;

import lombok.Data;

import java.util.Date;

/**
 * DTO for the entity Task
 */
@Data
public class TaskDto {
    private Long idTask;
    private String title;
    private String notes;
    private Date createDate;
    private Date dueDate;
    private PriorityDto priority;
    private StatusDto status;
    private UserDto user;
}
