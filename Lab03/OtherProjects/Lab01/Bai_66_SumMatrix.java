package Lab01;
import java.util.Scanner;

public class Bai_66_SumMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma tran tu ban phim (phim 1) hoac dung ma tran co san (phim 2): ");
        int choice = sc.nextInt();
        int rows, cols;
        int[][] matrix1, matrix2;

        if (choice == 1) {
            System.out.println("Nhap so hang cua ma tran:");
            rows = sc.nextInt();
            System.out.println("Nhap so cot cua ma tran:");
            cols = sc.nextInt();

            matrix1 = new int[rows][cols];
            matrix2 = new int[rows][cols];
            System.out.println("Nhap cac phan tu cho ma tran 1:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix1[i][j] = sc.nextInt();
                }
            }
            System.out.println("Nhap cac phan tu cho ma tran 2:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix2[i][j] = sc.nextInt();
                }
            }
        } else {
            rows = 2; cols = 3;
            matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}};
            matrix2 = new int[][]{{7, 8, 9}, {1, 0, 2}};
            System.out.println("Dang su dung ma tran mau kich thuoc 2x3.");
        }
        int[][] sumMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("\nMa tran 1:");
        printMatrix(matrix1);
        System.out.println("Ma tran 2:");
        printMatrix(matrix2);
        System.out.println("Ma tran tong la:");
        printMatrix(sumMatrix);

        sc.close();
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}