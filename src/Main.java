import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Boolean typeResult = false;
        String operator;
        int firstInt;
        int secondInt;

        System.out.print("Введите уровнение: ");
        String input = GetString();
        input = input.trim().toUpperCase();
        String[] inputArrey = input.split(" ");

//        ---------Считает разные числа!----------
//        if (checkInput(inputArrey[0])) {
//            typeResult = true;
//            firstInt = ConverterRomeToInteger.RomanToint(inputArrey[0]);
//        } else {
//            firstInt = Integer.parseInt(inputArrey[0]);
//        }
//        if (checkInput(inputArrey[2])) {
//            typeResult = true;
//            secondInt = ConverterRomeToInteger.RomanToint(inputArrey[2]);
//        } else {
//            secondInt = Integer.parseInt(inputArrey[2]);
//        }

        //        ---------Считает одинаковые числа!----------
        try {
            if (checkInput(inputArrey[0]) && checkInput(inputArrey[2])) {
                typeResult = true;
                firstInt = RomeConverter.RomanToint(inputArrey[0]);
                secondInt = RomeConverter.RomanToint(inputArrey[2]);
            } else {
                firstInt = Integer.parseInt(inputArrey[0]);
                secondInt = Integer.parseInt(inputArrey[2]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Числа разных форматов");
        }

        operator = inputArrey[1];

        // Проверка величины введенных чисел
        if (firstInt > 10||secondInt > 10) throw  new IllegalArgumentException("Одно из чисел больше 10");

        // Вывод результата
        if (typeResult) System.out.println("Результат: " + RomeConverter.IntToRoman(calculate(firstInt, secondInt, operator)));
        else System.out.println("Результат: " + calculate(firstInt, secondInt, operator));
    }

    // Чтение из консоли
    private static String GetString() {
        Scanner scanner = new Scanner(System.in);
        String enterString = scanner.nextLine();
        return enterString;
    }


    // Проверка на римскость)
    public static Boolean checkInput(String temp1) {
        String[] rim = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        boolean status = false;
        for (String e : rim
        ) {
            if (temp1.contains(e)) status=true;
        }
        return status;
    }

    // Калькулятор
    public static int calculate(int first, int second, String operator){
        int result = 0;
        switch (operator){
            case "+": result = first + second; break;
            case "-": result = first - second; break;
            case "*": result = first * second; break;
            case "/": result = first / second; break;
            default:throw  new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}