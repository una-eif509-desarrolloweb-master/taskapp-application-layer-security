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
 * Entity for the role
 */
@Entity
@Table( name = "role" )
public class Role {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    @Getter @Setter
    private Long idRole;
    @Getter @Setter
    private String name;

    // Relationship definition
    @ManyToMany(mappedBy = "roleList")
    @Getter @Setter private List<User> usersList;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_privilege"))
    @Getter @Setter
    private List<Privilege> privilegeList;
}
