package de.philippmos.store.mappers;

import de.philippmos.store.dtos.UserDto;
import de.philippmos.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
