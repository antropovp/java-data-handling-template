package com.epam.izh.rd.online.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileServiceImpl {

    public String readTextFromFile(String filePath) {
        String textFromFile = "";

        try (FileReader fileReader = new FileReader(filePath)) {

            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()) {
                textFromFile += scanner.nextLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return textFromFile;
    }
}
