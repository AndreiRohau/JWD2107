package com.jwd.streamApi;

import com.jwd.domain.User;
import com.jwd.domain.UserDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MainC {
    public static void main(String[] args) {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = Arrays.asList(
                new User(1L, "Adu", 31),
                new User(2L, "Budha", 32),
                new User(3L, "Citramon", 33),
                new User(4L, "Demencia", 44),
                new User(5L, "Efrat", 55),
                new User(6L, "Farengeit", 66)
        );

        final Function<User, UserDto> func = (user) -> new UserDto(user.getLogin(), user.getAge());

        users.stream()
                .filter(user -> user.getAge() > 40)
                .map(func)
                .forEach(userDto -> {
                    userDtos.add(userDto);
                });

        System.out.println(userDtos.size());
    }
}
