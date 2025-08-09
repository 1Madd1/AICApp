package org.aiesec.aicapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.aiesec.aicapp.dto.UserDto;
import org.aiesec.aicapp.entity.User;
import org.aiesec.aicapp.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiResponse(responseCode = "200", description = "Returns a User with a given id of an existing user",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDto.class))})
    @Operation(summary = "A GET request that returns ResponseEntity<User> via given id.")
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@Parameter(description = "id of an existing User") @PathVariable(name = "id") UUID userId) {
        System.out.println("UserController.geyById with id: " + userId + " called");

        User user = userService.findUserById(userId);

        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "A POST request that returns ResponseEntity<User> after creating a new User via given UserDto as a request body.")
    @PostMapping
    public ResponseEntity<User> createUser(@Parameter(description = "a UserDto with all necessary information without an id") @RequestBody UserDto userDto) {
        System.out.println("UserController.createUser called - " + userDto);

        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @Operation(summary = "A PUT request that returns ResponseEntity<User> after updating existing User via given UserDto as a request body.")
    @PutMapping
    public ResponseEntity<User> updateUser(@Parameter(description = "a UserDto with all necessary information and with an id of an existing User") @RequestBody UserDto userDto) {
        System.out.println("UserController.updateUser called - " + userDto);

        return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }
//
//    @Operation(summary = "A DELETE request that removes a User via given id of an existing User and returns OK if delete was successful, error code 409 if not.")
//    @DeleteMapping
//    public ResponseEntity deleteUserById(@Parameter(description = "id of an existing User") @RequestParam UUID userId) {
//        System.out.println("UserController.deleteUserById called for userID - " + userId);
//        userService.deleteUser(userId);
//        return userService.findUserById(userId) == null ? ResponseEntity.ok().build() : new ResponseEntity<>(HttpStatus.valueOf(409));
//    }
//
//    @Operation(summary = "A GET request that returns ResponseEntity<Page<User>> and takes request params page, size, sortBy and ascending which are optional.")
//    @GetMapping
//    public ResponseEntity<Page<User>> findAll(@Parameter(description = "on what page to be on ") @RequestParam(defaultValue = "0") int page,
//                                               @Parameter(description = "size of a single page") @RequestParam(defaultValue = "5") int size,
//                                               @Parameter(description = "in what field the page object needs to sort by (e.g. title, theme, status...)") @RequestParam(defaultValue = "id") String sortBy,
//                                               @Parameter(description = "an ascending order if true, descending order if false") @RequestParam(defaultValue = "true") boolean ascending) {
//        System.out.println("UserController.findAll called");
//        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        return ResponseEntity.ok(userService.findAllUsers(pageable));
//    }
//
//    @Operation(summary = "A GET request that returns ResponseEntity<Page<User>> via given firstName and takes request params page, size, sortBy and ascending which are optional.")
//    @GetMapping("/find-all-by-name")
//    public ResponseEntity<Page<User>> findAllByFirstName(@Parameter(description = "used for finding an existing User that contains givens first name") @RequestParam String firstName,
//                                                          @Parameter(description = "on what page to be on ") @RequestParam(defaultValue = "0") int page,
//                                                          @Parameter(description = "size of a single page") @RequestParam(defaultValue = "5") int size,
//                                                          @Parameter(description = "in what field the page object needs to sort by (e.g. title, theme, status...)") @RequestParam(defaultValue = "id") String sortBy,
//                                                          @Parameter(description = "an ascending order if true, descending order if false") @RequestParam(defaultValue = "true") boolean ascending) {
//        System.out.println("UserController.findAllByName called with first name - " + firstName);
//        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        return new ResponseEntity<>(userService.findAllByFirstName(firstName, pageable), HttpStatus.OK);
//    }
//
//    @Operation(summary = "A GET request that returns ResponseEntity<User> via given email.")
//    @GetMapping("/find-user-by-email")
//    public ResponseEntity<User> findUserByEmail(@Parameter(description = "used for finding an existing User that contains givens email") @RequestParam String email) {
//        System.out.println("UserController.findUserByEmail called with email -" + email);
//        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
//    }

}
