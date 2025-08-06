package org.aiesec.aicapp.service;

import org.aiesec.aicapp.dto.UserDto;
import org.aiesec.aicapp.entity.User;

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
     * @param userId - valid user UUID
     * @return User with provided id if one exists
     */
    User findUserById(UUID userId);
}
