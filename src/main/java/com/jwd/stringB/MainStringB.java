package com.jwd.stringB;

public class MainStringB {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(); // since 1.0, slow threadsafe object
        StringBuilder stringBuilder = new StringBuilder("other text"); // since 1.5 fast not threadsafe object

        sb.append('a');
        sb.append('b')
                .append('c')
                .append("d");
        sb.append("e"); // index 4
        sb.append("f");
        sb.append(1);
        sb.append(2L);
        sb.append(3.0d); // index 8, 9, 10
        sb.append(0.5);
//        sb.append(0.5);
        System.out.println("capacity = " + sb.capacity());
        System.out.println("length = " + sb.length());
        System.out.println("charAt(4) is e = " + sb.charAt(8));
        System.out.println("toString() = " + sb);
        System.out.println("reverse() = " + sb.reverse());
        sb.trimToSize();

        // To compare to StringBuilders (Buffers) we use their toString() results.
        System.out.println(
                sb.toString().equals(stringBuilder.toString())
        );

    }

}
