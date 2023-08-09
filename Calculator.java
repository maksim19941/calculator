package calculator;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.String;

 class Calculator {

     public static void main(String[] args) throws Exception {

         Scanner scanner = new Scanner(System.in);
         System.out.println("Введите числа :");
         String inputData = scanner.nextLine();
         boolean arabian_or_rome;

             if (inputData.contains("1")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("2")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("3")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("4")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("5")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("6")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("7")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("8")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("9")) {
                 arabian_or_rome = true;
             } else if (inputData.contains("0")) {
                 arabian_or_rome = true;
             } else  arabian_or_rome = false;

             if (arabian_or_rome) {
                 System.out.println(arabianNumber(inputData));
             }else if (!arabian_or_rome){
                 System.out.println(romeNumber(inputData));
             }
     }



     //             Результат из арабских чисел
     public static int arabianNumber(String inputData) throws Exception {
         int numArab1;
         int numArab2;
         String sign;
         String[] oper = inputData.split("[+\\-*/]");
         if (oper.length != 2) throw new Exception("Должно быть два числа");
         sign = detectSymbol(inputData);
         numArab1 = Integer.parseInt(oper[0]);
         numArab2 = Integer.parseInt(oper[1]);
         int result = operation(numArab1, numArab2, sign);
         return result;
     }

     //                Результат из римских чисел
     public static String romeNumber(String inputData) throws Exception {
         int numRoman1;
         int numRoman2;
         String result;
         String sign;
         String[] oper = inputData.split("[+\\-*/]");
         if (oper.length != 2) throw new Exception("Должно быть два числа");
         sign = detectSymbol(inputData);
         numRoman1 = Roman.convertToArabian(oper[0]);
         numRoman2 = Roman.convertToArabian(oper[1]);
         int arabian = operation(numRoman1, numRoman2, sign);
         result = Roman.convertToRoman(arabian);
         return result;
     }

     //            Возвращаю символ через split
     static String detectSymbol(String inputData) {
         if (inputData.contains("+")) return "+";
         else if (inputData.contains("-")) return "-";
         else if (inputData.contains("*")) return "*";
         else if (inputData.contains("/")) return "/";
         else return null;
     }

     //        Возвращаю полученное число
     static int operation(int a, int b, String sign) {
         if (sign.equals("+")) return a + b;
         else if (sign.equals("-")) return a - b;
         else if (sign.equals("*")) return a * b;
         else return a / b;
     }


     class Roman {
         static String[] romanlist = new String[]{"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                 "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                 "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                 "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                 "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                 "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                 "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                 "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                 "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                 "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


         public static int convertToArabian(String roman) {
             for (int i = 0; i < romanlist.length; i++) {
                 if (roman.equals(romanlist[i])) {
                     return i;
                 }
             }
             return -1;
         }

         public static String convertToRoman(int arabian) {
             return romanlist[arabian];
         }

     }
 }
