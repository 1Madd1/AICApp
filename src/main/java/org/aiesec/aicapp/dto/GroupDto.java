package org.aiesec.aicapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private UUID id;
    private String groupName;
    private LocalDate groupCreationDate;

}
