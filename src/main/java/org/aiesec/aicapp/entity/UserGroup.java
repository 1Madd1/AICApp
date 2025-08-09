package org.aiesec.aicapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aiesec.aicapp.entity.enums.Role;

import java.util.UUID;

@Entity(name = "user_group")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "role")
    private Role role;

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;
}
