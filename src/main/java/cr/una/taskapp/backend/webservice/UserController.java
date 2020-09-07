package cr.una.taskapp.backend.webservice;

import cr.una.taskapp.backend.common.Constants;
import cr.una.taskapp.backend.dto.UserDto;
import cr.una.taskapp.backend.model.User;
import cr.una.taskapp.backend.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Webservice Controller for User
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "users")
public class UserController {
    @Autowired
    private IUserService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Save the new User
     * @param userDto the User saved
     * @return
     */
    @PostMapping(path = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto signUp(@Valid @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(service.create(user));
    }

    /**
     * Convert from Entity to DTO
     * @param user entity
     * @return the DTO
     */
    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    /**
     * Convert from DTO to Entity
     * @param userDto the DTO
     * @return the entity
     */
    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
