package com.codingiscaring;

import com.codingiscaring.firstdecember.FirstDecember;

import java.io.File;
import java.util.Scanner;

public class FileUtils {
    public static File getFileFrom(String fileName) {
        ClassLoader classLoader = FirstDecember.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public static boolean isNotTheEndOfFile(Scanner fileContent) {
        return fileContent.hasNextLine();
    }
}
