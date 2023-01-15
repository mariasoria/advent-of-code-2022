package com.codingiscaring.thirddecember;

import com.codingiscaring.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThirdDecember {

    public static Integer findSumPriorities(String fileName) throws FileNotFoundException {
        int sumOfPriorities = 0;
        File file = FileUtils.getFileFrom(fileName);

        Scanner fileContent = new Scanner(file);
        while (FileUtils.isNotTheEndOfFile(fileContent)) {
            String rucksackContent = fileContent.nextLine();
            char item = findRucksackPriorityItem(rucksackContent);
            sumOfPriorities += calculatePriorityForCurrentRucksack(item);
        }
        return sumOfPriorities;

    }

    public static char findRucksackPriorityItem(String rucksackContent) {
        int compartmentSize = rucksackContent.length() / 2;
        String firstCompartment = rucksackContent.substring(0, compartmentSize);
        String secondCompartment = rucksackContent.substring(compartmentSize);

        for (int position = 0; position < firstCompartment.length(); position++) {
            String actualItem = Character.toString(firstCompartment.charAt(position));
            if (secondCompartment.contains(actualItem)) {
                return firstCompartment.charAt(position);
            }
        }
        return ' ';
    }

    private static int calculatePriorityForCurrentRucksack(char priorityItem) {
        if (isLowerCase(priorityItem)) {
            return priorityItem - 96;
        } else {
            return priorityItem - 38;
        }
    }

    private static boolean isLowerCase(int asciiValue) {
        return asciiValue >= 97 && asciiValue <= 122;
    }

}

