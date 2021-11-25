package com.jwd.D_serialization;

public class PersonImpl extends Person {
    String personImplName;
    int personImplAge;

    public PersonImpl(int yo_transient, int simple_int, String simple_string, String comprehensive_string, Address address, String personImplName, int personImplAge) {
        super(yo_transient, simple_int, simple_string, comprehensive_string, address);
        this.personImplName = personImplName;
        this.personImplAge = personImplAge;
    }
}
