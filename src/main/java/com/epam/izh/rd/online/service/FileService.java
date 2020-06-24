package com.epam.izh.rd.online.service;

import java.io.File;

public interface FileService {

    String readTextFromFile(String filePath);

    File[] getFilesInDirectoryInsideResourcesFolder(String directory);
}
