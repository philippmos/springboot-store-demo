package de.philippmos.store.controllers;

import de.philippmos.store.dtos.RegisterUserRequest;
import de.philippmos.store.dtos.UserDto;
import de.philippmos.store.mappers.UserMapper;
import de.philippmos.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers(
            @RequestHeader(required = false, name = "x-auth-token") String authToken,
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort
    ) {
        System.out.println("AuthToken: " + authToken);

        if (!Set.of("name", "email").contains(sort)) {
            sort = "name";
        }

        return userRepository
                .findAll(Sort.by(sort).descending())
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        var user =  userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
    ) {
        var user = userMapper.toEntity(request);

        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        var uri = uriBuilder
                        .path("/users/{id}")
                        .buildAndExpand(userDto.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(userDto);
    }
}
