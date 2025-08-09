package org.aiesec.aicapp.service;

import org.aiesec.aicapp.dto.UserDto;
import org.aiesec.aicapp.entity.User;
import org.aiesec.aicapp.entity.UserGroup;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    /***
     *  Create and persist an agent
     *
     * @param userDto - Newly created user
     * @return Valid user object
     */
    User createUser(UserDto userDto);

    /***
     *  Update user data fields
     *
     * @param userDto - must be a valid user object with valid id
     * @return Updated User object
     */
    User updateUser(UserDto userDto);

    /***
     * @param userId - valid user UUID
     * @return User with provided id if one exists
     */
    User findUserById(UUID userId);
}
