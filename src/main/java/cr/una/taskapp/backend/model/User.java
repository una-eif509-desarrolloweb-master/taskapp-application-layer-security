/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Entity for the user
 */
@Entity
@Table( name = "users" )
public class User {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @Getter @Setter
    private Long idUser;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private Date createDate;
    @Getter @Setter
    private boolean enabled;
    @Getter @Setter
    private boolean tokenExpired;

    // Relationship definition
    @OneToMany(mappedBy = "user")
    private List<Task> taskList;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    @Getter @Setter
    private List<Role> roleList;
}
