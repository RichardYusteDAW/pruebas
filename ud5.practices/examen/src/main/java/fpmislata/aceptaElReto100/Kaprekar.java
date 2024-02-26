package fpmislata.aceptaElReto100;

import java.util.Arrays;

public class Kaprekar {

    private final int KAPREKAR_CONSTANT = 6174;

    public int kaprekarRoutine(int num) {
        int cont = 0;

        if (num == KAPREKAR_CONSTANT)
            return 0;

        if (isRepdigit(num))
            return 8;

        while (num != KAPREKAR_CONSTANT) {
            int asc = sortDigits(num, true);
            int desc = sortDigits(num, false);
            num = desc - asc;
            cont++;
        }

        return cont;
    }

    private boolean isRepdigit(int num) {
        // Transform any number in at least 4 numbers array:
        char[] digits = String.format("%04d", num).toCharArray();

        int firstNum = digits[0];
        for (char digit : digits) {
            if (digit != firstNum)
                return false;
        }
        return true;
    }

    private int sortDigits(int number, boolean ascending) {
        char[] digits = String.format("%04d", number).toCharArray();
        if (ascending) {
            Arrays.sort(digits);
        } else {
            Arrays.sort(digits);
            reverseArray(digits);
        }
        return Integer.parseInt(new String(digits));
    }

    private void reverseArray(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    /* Esta sería una versión de reverseArray más lenta */
    // private static char[] reverseArray(char[] array) {
    // char[] newArray = new char[array.length];
    // for (int i = 0; i < array.length; i++) {
    // newArray[i] = array[array.length - 1 - i];
    // }
    // return newArray;
    // }
}