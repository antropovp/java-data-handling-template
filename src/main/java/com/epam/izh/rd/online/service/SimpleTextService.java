package com.epam.izh.rd.online.service;

import com.sun.deploy.util.StringUtils;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     *
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, "");
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     *
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        return !text.isEmpty() && text.charAt(text.length() - 1) == '?';
    }

    /**
     * Реализовать функционал соединения переданных строк.
     *
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {

        String concatenatedString = "";

        for (String element: elements) {
            concatenatedString += element;
        }

        return concatenatedString;
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     *
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {

        String textInJumpCase = "";

        for (int i = 0; i < text.length(); i++) {
            if (i%2 == 0) {
                textInJumpCase += text.substring(i, i + 1).toLowerCase();
            } else {
                textInJumpCase += text.substring(i, i + 1).toUpperCase();
            }
        }

        return textInJumpCase;
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     *
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     *
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {

        String cleanString = string.replaceAll("(?U)\\W", "");
        int indexOfLastElementOfString = cleanString.length() - 1;

        for (int i = 0; i < cleanString.length(); i++) {
            if (!cleanString.substring(i, i + 1)
                    .equalsIgnoreCase(cleanString.substring(indexOfLastElementOfString - i, indexOfLastElementOfString - i + 1))) {
                return false;
            }
        }

        return !string.isEmpty();
    }
}
