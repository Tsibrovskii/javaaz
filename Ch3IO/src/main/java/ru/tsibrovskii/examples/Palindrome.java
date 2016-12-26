package ru.tsibrovskii.examples;

import java.io.*;

/**
 * Класс, проверяющий слово, является ли оно палиндромом.
 */
public class Palindrome {

    private char[] palindromWord;

    /**
     * Метод, проверяющий слово, является ли оно палиндромом.
     * @param in входящий поток.
     * @return результат.
     * @throws IOException исключение.
     */
    public boolean isPalindrome(InputStream in) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String str;
            String revertStr = "";

            if ((str = reader.readLine()) != null) {
                if (str.length() != 5) {
                    return false;
                }
                else {
                    palindromWord = str.toCharArray();
                    for (int i = palindromWord.length - 1; i >= 0; i--) {
                        revertStr = String.format("%s%s", revertStr, str.charAt(i));
                    }
                    return revertStr.equalsIgnoreCase(str);
                }
            } else return false;
        }
    }
}
