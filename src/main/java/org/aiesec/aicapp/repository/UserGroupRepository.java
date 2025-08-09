package org.aiesec.aicapp.repository;

import org.aiesec.aicapp.entity.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserGroupRepository extends JpaRepository<UserGroup, UUID> {
    Page<UserGroup> findAllByUserId(UUID userId, Pageable pageable);
}
