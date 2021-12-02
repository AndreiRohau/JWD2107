package com.jwd.functionalInterface;

@FunctionalInterface
public interface CustomFuncInterface<T> {
    T sayHi(T s);

    default T sayHi2(T s) {
        return s;
    }
}
