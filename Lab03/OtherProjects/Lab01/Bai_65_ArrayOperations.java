package Lab01;
import java.util.Arrays;
import java.util.Scanner;

public class Bai_65_ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap mang tu ban phim (phim 1) hoac dung mang co san (phim 2)");
        int choice = scanner.nextInt();
        double[] myArray;
        if (choice == 1) {
            System.out.println("Nhap so luong phan tu cua mang:");
            int n = scanner.nextInt();
            myArray = new double[n];
            System.out.println("Nhap cac phan tu:");
            for (int i = 0; i < n; i++) {
                myArray[i] = scanner.nextDouble();
            }
        } else {
            myArray = new double[]{1789, 2035, 1899, 1456, 2013};
            System.out.println("Dang su dung mang hang so: " + Arrays.toString(myArray));
        }
        Arrays.sort(myArray);
        double sum = 0;
        for (double x : myArray) {
            sum += x;
        }
        double average = sum / myArray.length;
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(myArray));
        System.out.println("Tong cac phan tu: " + sum);
        System.out.println("Gia tri trung binh: " + average);
        scanner.close();
    }
}