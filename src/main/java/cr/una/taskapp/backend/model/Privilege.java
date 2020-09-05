/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entity for the user
 */
@Entity
@Table( name = "privilege" )
public class Privilege {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_privilege")
    @Getter @Setter
    private Long idPrivilege;
    @Getter @Setter
    private String name;

    // Relationship definition
    @ManyToMany(mappedBy = "privilegeList")
    @Getter @Setter private List<Role> roleList;
}
