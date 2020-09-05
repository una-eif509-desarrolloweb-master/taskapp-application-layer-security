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

package cr.una.taskapp.backend.webservice;

import cr.una.taskapp.backend.dto.PriorityDto;
import cr.una.taskapp.backend.model.Priority;
import cr.una.taskapp.backend.service.IPriorityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for Priority
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/api/v1/priorities")
public class PriorityController {

    @Autowired
    private IPriorityService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Priorities
     * @return List of DTO Priorities
     */
    @GetMapping()
    @ResponseBody
    public List<PriorityDto> findAll() {
        List<Priority> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the priority by id
     * Endpoint: /api/v1/priorities/1
     * @return A priority found
     */
    @GetMapping("{id}")
    @ResponseBody
    public PriorityDto findById(@PathVariable Long id) {
        Priority priority = service.findById(id);
        return convertToDto(priority);
    }

    /**
     * Save the new Priority
     * @param priorityDto the priority saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PriorityDto save(@Valid @RequestBody PriorityDto priorityDto) {
        Priority priority = convertToEntity(priorityDto);
        return convertToDto(service.create(priority));
    }

    /**
     * Update the existing Priority
     * @param priorityDto the priority saved
     * @return the priority updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PriorityDto update(@Valid @RequestBody PriorityDto priorityDto) {
        Priority priority = convertToEntity(priorityDto);
        return convertToDto(service.update(priority));
    }

    /**
     * Delete user by id
     * @param id the id of the entity
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
    
    /**
     * Convert from Entity to DTO
     * @param priority entity
     * @return the DTO
     */
    private PriorityDto convertToDto(Priority priority) {
        PriorityDto priorityDto = modelMapper.map(priority, PriorityDto.class);
        return priorityDto;
    }

    /**
     * Convert from DTO to Entity
     * @param priorityDto the DTO
     * @return the entity
     */
    private Priority convertToEntity(PriorityDto priorityDto) {
        Priority priority = modelMapper.map(priorityDto, Priority.class);
        return priority;
    }
}