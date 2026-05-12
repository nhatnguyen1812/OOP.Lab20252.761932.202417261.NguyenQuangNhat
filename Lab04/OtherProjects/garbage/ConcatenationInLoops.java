package hust.soict.ep.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        // In ra thời gian chạy dùng toán tử + (thường mất khoảng 4500ms)
        System.out.println(System.currentTimeMillis() - start);

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        // In ra thời gian chạy dùng StringBuilder (thường chỉ mất khoảng 5ms)
        System.out.println(System.currentTimeMillis() - start);
    }
}