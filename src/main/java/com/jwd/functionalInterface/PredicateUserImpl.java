package com.jwd.functionalInterface;

import com.jwd.domain.User;

import java.util.function.Predicate;

public class PredicateUserImpl implements Predicate<User> {
    @Override
    public boolean test(User user) {
        return user.getAge() > 40;
    }
}
