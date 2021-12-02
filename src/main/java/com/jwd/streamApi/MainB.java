package com.jwd.streamApi;

import com.jwd.domain.User;
import com.jwd.domain.UserDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainB {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1L, "Adu", 31),
                new User(2L, "Budha", 32),
                new User(3L, "Citramon", 33)
        );

        List<UserDto> collect = users
                .stream()
                .map(user -> new UserDto(user.getLogin(), user.getAge()))
                .peek(userDto -> System.out.println(userDto))
                .collect(Collectors.toList());

        System.out.println();
        System.out.println(collect);
        System.out.println();

        users.stream()
                .map(user -> new UserDto(user.getLogin(), user.getAge()))
                .peek(userDto -> System.out.println(userDto))
                .map(userDto -> {
                    userDto.setAge(10 + userDto.getAge());
                    return userDto;
                })
                .forEach(userDto -> System.out.println(userDto));
    }
}
