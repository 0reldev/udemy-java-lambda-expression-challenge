package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));
//      [ANNA, BOB, CAROLE, DAVID, ED, FRED, GARY]

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));
//      [ANNA A., BOB B., CAROLE B., DAVID D., ED A., FRED D., GARY B.]

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        Arrays.asList(names).forEach(s -> System.out.println(s));
//        ANNA C. ANNA
//        BOB D. BOB
//        CAROLE A. ELORAC
//        DAVID A. DIVAD
//        ED A. DE
//        FRED B. DERF
//        GARY D. YRAG

        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf((s -> s.substring(0, s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1))));
        System.out.println("--> Remove names where first = last");
        newList.forEach(s -> System.out.println(s));
//        CAROLE B. ELORAC
//        DAVID D. DIVAD
//        ED D. DE
//        FRED C. DERF
//        GARY C. YRAG
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}