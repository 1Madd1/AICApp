package org.aiesec.aicapp.service;

import org.aiesec.aicapp.dto.GroupDto;
import org.aiesec.aicapp.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface GroupService {

    /***
     *  Create and persist an agent
     *
     * @param groupDto - Newly created group
     * @return Valid group object
     */
    Group createGroup(GroupDto groupDto);

    /***
     *  Update group data fields
     *
     * @param groupDto - must be a valid group object with valid id
     * @return Updated Group object
     */
    Group updateGroup(GroupDto groupDto);

    /***
     * @param groupId - valid group UUID
     * @return Group with provided id if one exists
     */
    Group findGroupById(UUID groupId);

    /**
     *
     * @param groupName - used to search through all existing groups
     * @param pageable - used for paging and sorting data
     * @return List of existing groups that contain given groupName
     */
    Page<Group> findAllByGroupName(String groupName, Pageable pageable);
}
