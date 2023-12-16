package ru.practicum.mainservice.models.user;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User toUser(UserDtoIn userDtoIn) {
        return User.builder()
                .email(userDtoIn.email)
                .name(userDtoIn.name)
                .build();
    }

    public UserDtoOut toUserDtoOut(User user) {
        return UserDtoOut.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public UserDtoOutShort toUserDtoOutShort(User user) {
        return UserDtoOutShort.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

}
