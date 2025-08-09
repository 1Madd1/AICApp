package org.aiesec.aicapp.config;

import org.aiesec.aicapp.repository.GroupRepository;
import org.aiesec.aicapp.repository.UserRepository;
import org.aiesec.aicapp.service.GroupService;
import org.aiesec.aicapp.service.UserService;
import org.aiesec.aicapp.service.impl.GroupServiceImpl;
import org.aiesec.aicapp.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    UserService userService(UserRepository userRepository) {
        return UserServiceImpl.builder()
                .userRepository(userRepository)
                .build();
    }

    @Bean
    GroupService groupService(GroupRepository groupRepository) {
        return GroupServiceImpl.builder()
                .groupRepository(groupRepository)
                .build();
    }

}
