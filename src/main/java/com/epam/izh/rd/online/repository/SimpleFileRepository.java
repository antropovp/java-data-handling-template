package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.service.FileServiceImpl;

import java.io.File;
import java.io.IOException;

public class SimpleFileRepository implements FileRepository {

    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директории
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {

        long numberOfFilesInDirectory = 0;

        File[] filesInDirectory = new FileServiceImpl().getFilesInDirectoryInsideResourcesFolder(path);

        for (File file: filesInDirectory) {
            if (file.isDirectory()) {
                numberOfFilesInDirectory += countFilesInDirectory(file.getPath());
            } else {
                numberOfFilesInDirectory++;
            }
        }

        return numberOfFilesInDirectory;
    }

    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {

        long numberOfDirsInDirectory = 1;

        File[] filesInDirectory = new FileServiceImpl().getFilesInDirectoryInsideResourcesFolder(path);

        for (File file: filesInDirectory) {
            if (file.isDirectory()) {
                numberOfDirsInDirectory += countDirsInDirectory(file.getPath());
            }
        }

        return numberOfDirsInDirectory;
    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        return;
    }

    /**
     * Метод создает файл на диске с расширением txt
     *
     * @param path путь до нового файла
     * @param name имя файла
     * @return был ли создан файл
     */
    @Override
    public boolean createFile(String path, String name) {

        File newFileDirectory = new File("./src/main/resources/" + path);
        newFileDirectory.mkdir();

        File newFile = new File(newFileDirectory, name);

        try {
            return newFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        return new FileServiceImpl().readTextFromFile("src/main/resources/" + fileName);
    }
}
