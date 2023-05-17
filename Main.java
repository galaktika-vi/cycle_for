import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //не забыть раскоментировать код, который нужно исполнить.
        
        //printMultiplesOfSeven();
        //printSumOfMultiplesOfThreeAndFive();
        //printSumOfPerfectSquares();
        //calculateSumOfPrimes();
        //countOccurrencesOfCharacter();
        //convertRomanToDecimal();
    }

    public static void printMultiplesOfSeven() {
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void printSumOfMultiplesOfThreeAndFive() {
        int sum = 0;
        boolean first = true;

        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                if (!first) {
                    System.out.print(" + ");
                }
                System.out.print(i);
                sum += i;
                first = false;
            }
        }
        System.out.println(" = " + sum);
    }

    public static void printSumOfPerfectSquares() {
        int sum = 0;
        boolean first = true;

        for (int i = 1; i * i <= 1000; i++) {
            if (!first) {
                System.out.print(" + ");
            }
            System.out.print(i * i);
            sum += i * i;
            first = false;
        }
        System.out.println(" = " + sum);
    }

    public static void calculateSumOfPrimes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 2; i < num; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println("Сумма простых чисел, меньших " + num + ", равна " + sum);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void countOccurrencesOfCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово:");
        String str = scanner.nextLine();
        System.out.println("Введите букву:");
        char ch = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println("Количество вхождений символа '" + ch + "' в строку '" + str + "' равно " + count);
    }

    public static void convertRomanToDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите римское число:");
        String romanNumeral = scanner.nextLine();
        int decimal = romanToDecimal(romanNumeral);
        System.out.println("Десятичное представление вашего числа: " + decimal);
    }

    public static int romanToDecimal(String romanNumeral) {
        int decimal = 0;
        int lastNumber = 0;
        for (int i = romanNumeral.length() - 1; i >= 0 ; i--) {
            char ch = romanNumeral.charAt(i);
            decimal = checkRoman(ch, lastNumber, decimal);
            lastNumber = mapRomanToInt(ch);
        }
        return decimal;
    }

    public static int mapRomanToInt(char ch){
        int decimal = 0;
        switch(ch){
            case 'M':
                decimal = 1000;
                break;
            case 'D':
                decimal = 500;
                break;
            case 'C':
                decimal = 100;
                break;
            case 'L':
                decimal = 50;
                break;
            case 'X':
                decimal = 10;
                break;
            case 'V':
                decimal = 5;
                break;
            case 'I':
                decimal = 1;
                break;
        }
        return decimal;
    }

    public static int checkRoman(char ch, int lastNumber, int decimal){
        if (lastNumber > mapRomanToInt(ch)) {
            decimal -= mapRomanToInt(ch);
        } else {
            decimal += mapRomanToInt(ch);
        }
        return decimal;
    }
}

