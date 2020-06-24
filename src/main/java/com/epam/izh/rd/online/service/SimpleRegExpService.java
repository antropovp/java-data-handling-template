package com.epam.izh.rd.online.service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {

        String textFromFile = new FileServiceImpl().readTextFromFile("./src/main/resources/sensitive_data.txt");

        textFromFile = textFromFile.replaceAll("(?<=\\w\\s)(\\d{4}(?!\\s\\W))", "****");

        return textFromFile;
    }

    /**
     * Метод должен считывать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {

        String textFromFile = new FileServiceImpl().readTextFromFile("./src/main/resources/sensitive_data.txt");

        String paymentAmountFormatted = BigDecimal.valueOf(paymentAmount).stripTrailingZeros().toString();
        String balanceFormatted = BigDecimal.valueOf(balance).stripTrailingZeros().toString();

        textFromFile = textFromFile.replaceAll("(\\$\\{payment_amount})", paymentAmountFormatted);
        textFromFile = textFromFile.replaceAll("(\\$\\{balance})", balanceFormatted);

        return textFromFile;
    }
}
