/*
 *
 *
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 *
 *
 */

package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity for Reminder
 */
@Entity
@Table( name = "reminder" )
public class Reminder {

    // Properties
    @Id
    @Getter @Setter
    private Long idReminder;
    @Getter @Setter
    @Column(name = "reminder_date")
    private Date reminderDate;

    // Relationship definition
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // Share the same primary key between 2 tables
    private Task task;
}
