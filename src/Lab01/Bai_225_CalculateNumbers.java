package Lab01;
import javax.swing.JOptionPane;

public class Bai_225_CalculateNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null,
                "Nhap so thu nhat:", "Nhap du lieu",
                JOptionPane.QUESTION_MESSAGE);

        String strNum2 = JOptionPane.showInputDialog(null,
                "Nhap so thu hai:", "Nhap du lieu",
                JOptionPane.QUESTION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double tong = num1 + num2;
        double hieu = num1 - num2;
        double tich = num1 * num2;

        String ketQua = "So thu nhat: " + num1 + "\n"
                + "So thu hai: " + num2 + "\n"
                + "----------------------------\n"
                + "Tong: " + tong + "\n"
                + "Hieu: " + hieu + "\n"
                + "Tich: " + tich + "\n";
        if (num2 != 0) {
            double thuong = num1 / num2;
            ketQua += "Thuong: " + thuong;
        } else {
            ketQua += "Thuong: Loi (do khong the chia cho so 0)";
        }
        JOptionPane.showMessageDialog(null, ketQua, "Ket qua tinh toan", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}