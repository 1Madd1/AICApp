package org.aiesec.aicapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aiesec.aicapp.entity.enums.Role;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupDto {
    private UUID id;
    private UUID userId;
    private UUID groupId;
    private Role role;
}
