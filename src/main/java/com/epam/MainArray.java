package com.epam;

public class MainArray {
    public static void main(String[] args) {
        int[] rooms0 = new int[20];
        rooms0[0] = 1;

        int[] rooms1 = { 1, 2, 3 };
        int[] rooms1_1 = { 1, 2, 3 };

        int[] rooms2;
        rooms2 = new int[] { 1, 2, 3 };

        int[][] matrix10_null = new int[10][];
        int[][] matrix10_10 = new int[10][10];
        int[][] matrix10_3 = { {}, {}, {} };
        System.out.println(matrix10_10[1][7]);
    }
}
