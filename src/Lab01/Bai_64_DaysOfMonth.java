package Lab01;
import java.util.Scanner;

public class Bai_64_DaysOfMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int month = -1;
        int year = -1;
        while (true) {
            System.out.println("Nhap thang: ");
            String inputMonth = keyboard.nextLine().trim();
            month = getMonth(inputMonth);
            if (month != -1) break;
            System.out.println("Thang khong hop le");
        }
        while (true) {
            System.out.println("Nhap nam: ");
            String inputYear = keyboard.nextLine().trim();
            try {
                year = Integer.parseInt(inputYear);
                if (year >= 0 && inputYear.length() >= 3) break;
                else System.out.println("Nam khong hop le");
            } catch (NumberFormatException e) {
                System.out.println("Nam phai la mot so nguyen");
            }
        }
        int days = calculateDays(month, year);
        System.out.println("Thang " + month + " nam " + year + " co " + days + " ngay.");
        keyboard.close();
    }
    private static int getMonth(String input) {
        String inputLower = input.toLowerCase();
        String[][] monthMap = {
                {"1", "january", "jan.", "jan"},
                {"2", "february", "feb.", "feb"},
                {"3", "march", "mar.", "mar"},
                {"4", "april", "apr.", "apr"},
                {"5", "may", "may.", "may"},
                {"6", "june", "jun.", "jun"},
                {"7", "july", "jul.", "jul"},
                {"8", "august", "aug.", "aug"},
                {"9", "september", "sept.", "sep"},
                {"10", "october", "oct.", "oct"},
                {"11", "november", "nov.", "nov"},
                {"12", "december", "dec.", "dec"}
        };

        for (int i = 0; i < 12; i++) {
            for (String variant : monthMap[i]) {
                if (inputLower.equals(variant)) return i + 1;
            }
        }
        return -1;
    }
    private static int calculateDays(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}