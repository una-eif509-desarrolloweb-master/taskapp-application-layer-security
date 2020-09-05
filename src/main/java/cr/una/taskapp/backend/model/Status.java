/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 *
 */

package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entity for Status
 */
@Entity
@Table( name = "status" )
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    @Getter @Setter
    private Long idStatus;
    @Getter @Setter
    private String label;

    // Relationship definition
    @OneToMany(mappedBy = "status")
    private List<Task> taskList;
}
