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

/**
 * DTO for the entity Status
 */
@Data
public class StatusDto {
    private Long idStatus;
    private String label;
}
