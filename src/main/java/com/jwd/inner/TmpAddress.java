package com.jwd.inner;

public class TmpAddress extends User.Address {

    public TmpAddress() {
        new User().super();
    }

    public TmpAddress(User user) {
        user.super();
    }
}
