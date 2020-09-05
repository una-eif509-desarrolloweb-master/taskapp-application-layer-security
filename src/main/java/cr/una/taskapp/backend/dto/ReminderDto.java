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
 * DTO for the entity Reminder
 */
@Data
public class ReminderDto {
    private Long idReminder;
    private Date reminderDate;
}
