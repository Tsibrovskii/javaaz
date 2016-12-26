package ru.tsibrovskii.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестовый класс.
 */
public class PalindromeTest {

    /**
     * Тестовый метод на проверку слова.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveWordShouldReturnTrue() throws IOException {

        Palindrome palindrome = new Palindrome();

        ByteArrayInputStream bInput = new ByteArrayInputStream("RotOr".getBytes());
        boolean res = palindrome.isPalindrome(bInput);

        Assert.assertThat(res, is(true));
    }

    /**
     * Тестовый метод на проверку слова.
     * @throws IOException исключение.
     */
    @Test
    public void whenGiveWordShouldReturnFalse() throws IOException {

        Palindrome palindrome = new Palindrome();

        ByteArrayInputStream bInput = new ByteArrayInputStream("onene".getBytes());
        boolean res = palindrome.isPalindrome(bInput);

        Assert.assertThat(res, is(false));
    }


}
