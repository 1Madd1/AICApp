package org.aiesec.aicapp.service;

import org.aiesec.aicapp.entity.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserGroupService {

    /**
     *
     * @param userId - valid user UUID
     * @param pageable - used for paging and sorting data
     * @return List of existing groups that contain given userId
     */
    Page<UserGroup> findUserGroupsByUserId(UUID userId, Pageable pageable);

}
