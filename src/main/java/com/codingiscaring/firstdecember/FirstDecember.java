package com.codingiscaring.firstdecember;

import com.codingiscaring.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FirstDecember {

    public static int countMostCalories(String fileName) throws FileNotFoundException {
        File file = FileUtils.getFileFrom(fileName);
        int currentTotal = 0;
        int mostCalories = 0;
        Scanner fileContent = new Scanner(file);
        while (FileUtils.isNotTheEndOfFile(fileContent)) {
            String currentLineContent = fileContent.nextLine();
            if (elfIsCarryingMoreCalories(currentLineContent)) {
                currentTotal += Integer.parseInt(currentLineContent);
            } else {
                if (currentTotal > mostCalories) {
                    mostCalories = currentTotal;
                }
                currentTotal = 0;
            }
        }
        return mostCalories;
    }

    public static int countTopThreeMostCalories(String filename) throws FileNotFoundException {
        File file = FileUtils.getFileFrom(filename);
        List<Integer> allCalories = new ArrayList<>();
        int currentTotal = 0;

        Scanner fileContent = new Scanner(file);
        while (FileUtils.isNotTheEndOfFile(fileContent)) {
            String currentLineContent = fileContent.nextLine();
            if (elfIsCarryingMoreCalories(currentLineContent)) {
                currentTotal += Integer.parseInt(currentLineContent);
            } else {
                allCalories.add(currentTotal);
                currentTotal = 0;
            }
        }
        return sumTopThreeCalories(getTopThreeMostCalories(allCalories));
    }

    private static List<Integer> getTopThreeMostCalories(List<Integer> allCalories) {
        return getSortedCalories(allCalories).subList(0, 3);
    }

    private static List<Integer> getSortedCalories(List<Integer> allCalories) {
        allCalories.sort(Collections.reverseOrder());
        return allCalories;
    }

    private static int sumTopThreeCalories(List<Integer> topThreeMostCalories) {
        return topThreeMostCalories.stream().reduce(0,Integer::sum);
    }

    private static boolean elfIsCarryingMoreCalories(String currentLineContent) {
        return !currentLineContent.equals("");
    }
}
