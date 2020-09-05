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
import java.util.List;

/**
 * DTO for the entity User
 */
@Data
public class UserDto {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Date createDate;
    private boolean enabled;
    private boolean tokenExpired;
    private List<RoleDto> roleList;
}
