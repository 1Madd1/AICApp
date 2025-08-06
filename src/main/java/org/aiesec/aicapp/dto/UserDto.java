package org.aiesec.aicapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate userCreationDate;
}
