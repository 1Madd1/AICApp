package org.aiesec.aicapp.repository;

import org.aiesec.aicapp.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    Page<Group> findAllByGroupNameContainingIgnoreCase(String groupName, Pageable pageable);
}
