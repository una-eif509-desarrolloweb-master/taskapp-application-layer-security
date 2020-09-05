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
import java.util.List;

/**
 * Entity for the priority
 */
@Entity
@Table( name = "priority" )
public class Priority {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_priority")
    @Getter @Setter
    private Long idPriority;
    @Column(name = "label")
    @Getter @Setter
    private String label;

    // Relationship definition
    @OneToMany(mappedBy = "priority")
    @Getter @Setter
    private List<Task> taskList;
}
