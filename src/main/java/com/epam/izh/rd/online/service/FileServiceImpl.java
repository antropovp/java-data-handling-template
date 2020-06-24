package com.epam.izh.rd.online.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileServiceImpl implements FileService {

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

    @Override
    public File[] getFilesInDirectoryInsideResourcesFolder(String directory) {

        File givenDirectory = new File("./src/main/resources/" + directory);
        if (!givenDirectory.exists()) {
            givenDirectory = new File(directory);
        }

        File[] filesInDirectory = new File[0];
        if (givenDirectory.isDirectory()) {
            filesInDirectory = givenDirectory.listFiles();
        }

        return filesInDirectory;
    }
}
