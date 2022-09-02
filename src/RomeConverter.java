import java.util.*;

public class RomeConverter {

    public static String IntToRoman(int number) {
        if (number >= 4000 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for (Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private static final NavigableMap<Integer, String> units;

    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

    public static int RomanToint(String roman) {

        int i = 0;
        int current = 0;
        int previous = 0;
        int arabic = 0;

        while (i < roman.length()) {
            char letter = roman.charAt(i);
            switch (letter) {
                case ('I'):
                    current = 1;
                    break;
                case ('V'):
                    current = 5;
                    break;
                case ('X'):
                    current = 10;
                    break;
                case ('L'):
                    current = 50;
                    break;
                case ('C'):
                    current = 100;
                    break;
                case ('D'):
                    current = 500;
                    break;
                case ('M'):
                    current = 1000;
                    break;
            }
            if (current > previous) {
                arabic += current - (previous * 2);
            } else {
                arabic += current;
            }
            previous = current;
            i += 1;
        }
        return arabic;
    }


}