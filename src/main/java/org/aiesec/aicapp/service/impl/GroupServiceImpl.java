package org.aiesec.aicapp.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aiesec.aicapp.dto.GroupDto;
import org.aiesec.aicapp.entity.Group;
import org.aiesec.aicapp.error.exception.EntityNotFoundException;
import org.aiesec.aicapp.repository.GroupRepository;
import org.aiesec.aicapp.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Builder
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    
    private final GroupRepository groupRepository;
    
    @Override
    public Group createGroup(GroupDto groupDto) {
//        if (groupRepository.findByEmail(groupDto.getEmail()).isPresent()) {
//            throw new EntityNotFoundException("Group with email" + groupDto.getEmail() + " already exists!");
//        }

        return groupRepository.save(Group.builder()
                .groupName(groupDto.getGroupName())
                .groupCreationDate(groupDto.getGroupCreationDate())
                .build());
    }

    @Override
    public Group updateGroup(GroupDto groupDto) {
        return groupRepository.save(Group.builder()
                .id(groupDto.getId())
                .groupName(groupDto.getGroupName())
                .groupCreationDate(groupDto.getGroupCreationDate())
                .build());
    }

    @Override
    public Group findGroupById(UUID groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if (group.isEmpty()) {
            throw new EntityNotFoundException("Group with id " + groupId + " not found!");
        }
        return group.get();
    }

    @Override
    public Page<Group> findAllByGroupName(String groupName, Pageable pageable) {
        return groupRepository.findAllByGroupNameContainingIgnoreCase(groupName, pageable);
    }
}
