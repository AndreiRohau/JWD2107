package com.jwd.immutable;

import java.util.List;

public class ImmutableObjectDto {

    private String formattedDate;
    private int i;
    private String text;
    private User user;
    private List<User> users;

    public ImmutableObjectDto(ImmutableObject immutableObject) {
        this.formattedDate = immutableObject.getDate(); // return your required format
        this.i = immutableObject.getI();
        this.text = immutableObject.getStr().toLowerCase();
        this.user = immutableObject.getUser();
        this.users = immutableObject.getUsers();
    }
}
