/*
 *
 *
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 *
 *
 */

package cr.una.taskapp.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * DTO for the entity Priority
 */
@Data
public class PriorityDto {
    private Long idPriority;
    @NotBlank(message = "Label is mandatory")
    private String label;
}
