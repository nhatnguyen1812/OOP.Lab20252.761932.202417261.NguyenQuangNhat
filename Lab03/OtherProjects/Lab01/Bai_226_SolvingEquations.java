package Lab01;
import javax.swing.JOptionPane;

public class Bai_226_SolvingEquations {
    public static void main(String[] args) {
        String menu = "Chon loai phuong trinh muon giai:\n"
                + "1. Bac nhat 1 an (ax + b = 0)\n"
                + "2. He phuong trinh bac nhat 2 an\n"
                + "3. Bac hai 1 an (ax^2 + bx + c = 0)\n"
                + "Nhap lua chon cua ban (1, 2, 3):";
        String choice = JOptionPane.showInputDialog(null, menu, "Menu Giai Phuong Trinh", JOptionPane.QUESTION_MESSAGE);
        if (choice == null) System.exit(0);

        switch (choice) {
            case "1":
                giaiBacNhat();
                break;
            case "2":
                giaiHePhuongTrinh();
                break;
            case "3":
                giaiBacHai();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Lua chon khong hop le!");
        }
        System.exit(0);
    }

    public static void giaiBacNhat() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));

        if (a == 0) {
            if (b == 0) JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
            else JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
        } else {
            JOptionPane.showMessageDialog(null, "Nghiem x = " + (-b / a));
        }
    }

    public static void giaiHePhuongTrinh() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhap b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhap b2:"));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            JOptionPane.showMessageDialog(null, "He co nghiem duy nhat:\nx1 = " + (D1 / D) + "\nx2 = " + (D2 / D));
        } else {
            if (D1 == 0 && D2 == 0) JOptionPane.showMessageDialog(null, "He co vo so nghiem!");
            else JOptionPane.showMessageDialog(null, "He vo nghiem!");
        }
    }

    public static void giaiBacHai() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhap c:"));

        if (a == 0) {
            // Tro thanh PT bac nhat
            if (b == 0) {
                if (c == 0) JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem!");
                else JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem!");
            } else {
                JOptionPane.showMessageDialog(null, "Nghiem x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Phuong trinh co 2 nghiem phan biet:\nx1 = " + x1 + "\nx2 = " + x2);
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem kep: x = " + (-b / (2 * a)));
            } else {
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem!");
            }
        }
    }
}