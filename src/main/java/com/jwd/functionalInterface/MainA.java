package com.jwd.functionalInterface;

import com.jwd.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainA {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(0L, "Adushka", 17),
                new User(1L, "Adu", 31),
                new User(2L, "Budha", 32),
                new User(3L, "Citramon", 33), // indx 2
                new User(4L, "Demencia", 44), // indx 3
                new User(5L, "Efrat", 55),
                new User(6L, "Farengeit", 66)
        );
        Predicate<User> predicateAnon = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge() > 40;
            }
        };

        Predicate<User> predicateReal = new PredicateUserImpl();

        System.out.println(predicateAnon.test(users.get(3)));
        System.out.println(predicateAnon.test(users.get(4)));
        System.out.println(predicateReal.test(users.get(3)));
        System.out.println(predicateReal.test(users.get(4)));
        System.out.println("_____________________");
        System.out.println();
        Predicate<User> predicate18 = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge() > 18;
            }
        };
        Predicate<User> predicate21 = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge() > 21;
            }
        };
        System.out.println(isValidUser(predicate18, users.get(0)));
        System.out.println(isValidUser(predicate18, users.get(1)));
        System.out.println(isValidUser(predicate21, users.get(0)));
        System.out.println(isValidUser(predicate21, users.get(1)));

        System.out.println("examples of the same");
        Predicate<User> predicate_anon = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge() > 21;
            }
        };
        Predicate<User> predicate_lambda = (e) -> {
            return e.getAge() > 18;
        };
        Predicate<User> predicate_lambda_shortened = (e) -> (e.getAge() > 18);
        Predicate<User> predicate_lambda_shortened_most = e -> e.getAge() > 18;

        isValidUser((e) -> (e.getAge() > 18), users.get(0));

        Supplier<User> defaultUserSupplier = () -> new User(-1, "default_temp_login", 16);
        User newUser_1 = defaultUserSupplier.get();
        newUser_1.setId(1);
        User newUser_2 = defaultUserSupplier.get();
        newUser_2.setId(2);
        User newUser_3 = defaultUserSupplier.get();
        newUser_3.setId(3);
        User newUser_4 = defaultUserSupplier.get();
        newUser_4.setId(4);
        System.out.println(newUser_1);
        System.out.println(newUser_2);
        System.out.println(newUser_3);
        System.out.println(newUser_4);
    }

    public static boolean isValidUser(Predicate<User> predicate, User user) {
        return predicate.test(user);
    }


}
