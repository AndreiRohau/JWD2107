package com.jwd.streamApi;

import com.jwd.domain.User;
import com.jwd.domain.UserDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainD {
    public static void main(String[] args) {
        List<UserDto> userDtos = new ArrayList<>();
        List<UserDto> userDtos2 = new ArrayList<>();
        List<User> users = Arrays.asList(
                new User(1L, "Adu", 31),
                new User(2L, "Budha", 32),
                new User(3L, "Citramon", 33),
                new User(4L, "Demencia", 44),
                new User(5L, "Efrat", 55),
                new User(6L, "Farengeit", 66)
        );

        Stream<User> stream = users.stream();

        stream
                .filter(user -> user.getAge() > 40)
                .map(user -> new UserDto(user.getLogin(), user.getAge()))
                .forEach(userDto -> {
                    userDtos.add(userDto);
                });

        // throws error
        stream
                .filter(user -> user.getAge() > 40)
                .map(user -> new UserDto(user.getLogin(), user.getAge()))
                .forEach(userDto -> {
                    userDtos2.add(userDto);
                });

        System.out.println(userDtos.size());
        System.out.println(userDtos2.size());
    }
}
