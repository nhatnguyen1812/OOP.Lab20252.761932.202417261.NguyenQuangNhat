package Lab01;
import java.util.Scanner;

public class Bai_62_InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ten ban la gi?");
        String strName = keyboard.nextLine();

        System.out.println("Ban bao nhieu tuoi?");
        int iAge = keyboard.nextInt();
        System.out.println("Ban cao bao nhieu (m)?");
        double dHeight = keyboard.nextDouble();
        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " tuoi. "
                + "Chieu cao cua ban la " + dHeight + ".");
        keyboard.close();
    }
}