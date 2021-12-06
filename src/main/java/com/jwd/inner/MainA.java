package com.jwd.inner;
/*
compiled classes:
User.class
User$Address.class
 */
public class MainA {

    /*
    св-ва внутренних классов:
    1 - доступ к эл. внутреннего класса только через внешний
    2 - методы внутреннего имют прямой доступ к полям и методам внешнего
    3 -
     */

    // https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java

    private enum TmpEnum {
        START("старт", "start"),
        END("конец", "end");

        private String aliasRu;
        private String aliasEn;

        TmpEnum(String aliasRu, String aliasEn) {
            this.aliasRu = aliasRu;
            this.aliasEn = aliasEn;
        }
    }

    public static void main(String[] args) {
        System.out.println(TmpEnum.START);
        System.out.println(TmpEnum.END);

        User.Address address = new User().new Address();
        User.UserAddressComparator.staticM();

        User.UserAddressComparator comparator = new User.UserAddressComparator();
    }
}
