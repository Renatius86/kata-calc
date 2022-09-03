import java.util.Scanner;
import java.util.Arrays;
//import org.apache.commons.lang3.ArrayUtils;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Input: ");
        String str = in.nextLine();
        String output = calc(str);
        System.out.printf("Output:\n%s", output);
        in.close();
    }
    public static String calc(String input) throws Exception {

        String[] arr = input.split(" ");
        int index = 0;
        String[] result = new String[3];
        for (var item : arr) {
            if (item.equals(null) || item.equals("")) {
                continue;
            } else {
                if (index > 2) {
                    throw new Exception("Wrong input. Too long expression.");
                }
                result[index] = item;
                index++;
            }
        }
        String arabicNum[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String romNum[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String romNumFull[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int a = 0;
        int b = 0;
        boolean isArabic = false;
        boolean isRoman = false;
        if (Arrays.asList(arabicNum).contains(result[0]) && Arrays.asList(arabicNum).contains(result[2])) {
            a = Integer.parseInt(result[0]);
            b = Integer.parseInt(result[2]);
            isArabic = true;
        } else if (Arrays.asList(romNum).contains(result[0]) && Arrays.asList(romNum).contains(result[2])) {
            a = Arrays.asList(romNum).indexOf(result[0]) + 1;
            b = Arrays.asList(romNum).indexOf(result[2]) + 1;
            isRoman = true;
        } else {
            throw new Exception("Wrong input. Number types is not matching.");
        }
        int endResult = 0;
        String endResult2 = "";
        switch (result[1]) {
            case "+":
                endResult = a + b;
                break;
            case "-":
                endResult = a - b;
                break;
            case "*":
                endResult = a * b;
                break;
            case "/":
                endResult = a / b;
                break;
        }
        if (isRoman) {
            if (endResult <= 0) {
                throw new Exception("Wrong input. The result must be greater then 0");
            }
            endResult2 = romNumFull[endResult - 1];
        } else if (isArabic) {
            endResult2 += endResult;
        }
        return endResult2;
    }
}