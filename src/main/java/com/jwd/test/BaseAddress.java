package com.jwd.test;

public class BaseAddress {
    {
        System.out.println("1 BaseAddress");
    }
    static {
        System.out.println("1 static");
    }
    private String planet;

//    public BaseAddress() {
//        System.out.println("baseAddress constructor");
//    }

    {
        System.out.println("2 BaseAddress");
    }
    static {
        System.out.println("2 static");
    }
    public BaseAddress(String planet) {
        super();
        this.planet = planet;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    {
        System.out.println("3 BaseAddress");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseAddress that = (BaseAddress) o;

        return planet != null ? planet.equals(that.planet) : that.planet == null;
    }

    static {
        System.out.println("3 static");
    }
    @Override
    public int hashCode() {
        return planet != null ? planet.hashCode() : 0;
    }
}
