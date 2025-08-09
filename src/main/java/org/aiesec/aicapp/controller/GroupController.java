package org.aiesec.aicapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.aiesec.aicapp.dto.GroupDto;
import org.aiesec.aicapp.entity.Group;
import org.aiesec.aicapp.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @ApiResponse(responseCode = "200", description = "Returns a Group with a given id of an existing group",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = GroupDto.class))})
    @Operation(summary = "A GET request that returns ResponseEntity<Group> via given id.")
    @GetMapping("/{id}")
    public ResponseEntity<Group> getById(@Parameter(description = "id of an existing Group") @PathVariable(name = "id") UUID groupId) {
        System.out.println("GroupController.geyById with id: " + groupId + " called");

        Group group = groupService.findGroupById(groupId);

        return group != null ? ResponseEntity.ok(group) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "A POST request that returns ResponseEntity<Group> after creating a new Group via given GroupDto as a request body.")
    @PostMapping
    public ResponseEntity<Group> createGroup(@Parameter(description = "a GroupDto with all necessary information without an id") @RequestBody GroupDto groupDto) {
        System.out.println("GroupController.createGroup called - " + groupDto);

        return new ResponseEntity<>(groupService.createGroup(groupDto), HttpStatus.CREATED);
    }

    @Operation(summary = "A PUT request that returns ResponseEntity<Group> after updating existing Group via given GroupDto as a request body.")
    @PutMapping
    public ResponseEntity<Group> updateGroup(@Parameter(description = "a GroupDto with all necessary information and with an id of an existing Group") @RequestBody GroupDto groupDto) {
        System.out.println("GroupController.updateGroup called - " + groupDto);

        return new ResponseEntity<>(groupService.updateGroup(groupDto), HttpStatus.OK);
    }

    @Operation(summary = "A GET request that returns ResponseEntity<Page<Group>> via given firstName and takes request params page, size, sortBy and ascending which are optional.")
    @GetMapping("/find-all-by-group-name")
    public ResponseEntity<Page<Group>> findAllByGroupName(@Parameter(description = "used for finding an existing Group that contains givens group name") @RequestParam String groupName,
                                                          @Parameter(description = "on what page to be on ") @RequestParam(defaultValue = "0") int page,
                                                          @Parameter(description = "size of a single page") @RequestParam(defaultValue = "5") int size,
                                                          @Parameter(description = "in what field the page object needs to sort by") @RequestParam(defaultValue = "id") String sortBy,
                                                          @Parameter(description = "an ascending order if true, descending order if false") @RequestParam(defaultValue = "true") boolean ascending) {
        System.out.println("GroupController.findAllByGroupName called with first name - " + groupName);
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(groupService.findAllByGroupName(groupName, pageable), HttpStatus.OK);
    }

}
