package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ISBN (10 chữ số): ");
        String isbn = scanner.nextLine();


        if (isbn.length() != 10) {
            System.out.println("Số ISBN phải có 10 chữ số.");
            return;
        }


        int sum = 0;
        Stack<Integer> digits = new Stack<>();
        for (int i = 0; i < 10; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("Số ISBN chỉ được chứa các chữ số từ 0 đến 9.");
                return;
            }
            int digit = Character.getNumericValue(c);
            digits.push(digit);
            sum += (i + 1) * digit;
        }


        if (sum % 11 == 0) {
            System.out.println("Số ISBN bạn nhập là hợp lệ.");
        } else {
            System.out.println("Số bạn nhập không phải là số ISBN.");
        }
    }

}
