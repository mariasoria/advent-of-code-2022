package com.codingiscaring.seconddecember;

import com.codingiscaring.firstdecember.FirstDecember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecondDecember {

    public static Integer playRockPaperScissors(String fileName) throws FileNotFoundException {
        File file = getFileFrom(fileName);
        int score = 0;

        Scanner fileContent = new Scanner(file);
        while (!isTheEndOfFile(fileContent)) {
            String nextLine = fileContent.nextLine();
            String opponentsPlay = nextLine.split(" ")[0];
            String personalPlay = nextLine.split(" ")[1];
            score += calculateScore(opponentsPlay, personalPlay);
        }
        return score;
    }

    private static Integer calculateScore(String opponentsPlay, String personalPlay) {
        int lostScore = 0;
        int winScore = 6;
        int rock = 1;
        int paper = 2;
        int scissors = 3;

        if (havePlayedTheSame(opponentsPlay, personalPlay)) {
            return calculateDrawScore(personalPlay);
        }
        if (isRock(opponentsPlay)) {
            if (isPaper(personalPlay)) {
                return winScore + paper;
            } else {
                return lostScore + scissors;
            }
        }
        if (isPaper(opponentsPlay)) {
            if (isRock(personalPlay)) {
                return lostScore + rock;
            } else {
                return winScore + scissors;
            }
        }
        if (isScissors(opponentsPlay) && isRock(personalPlay)) {
            return winScore + rock;
        }
        return lostScore + paper;
    }

    private static Integer calculateDrawScore(String personalPlay) {
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int drawScore = 3;

        if (isRock(personalPlay)) {
            return drawScore + rock;
        }
        if (isPaper(personalPlay)) {
            return drawScore + paper;
        } else {
            return drawScore + scissors;
        }
    }

    private static boolean havePlayedTheSame(String opponentsPlay, String personalPlay) {
        return (isRock(opponentsPlay) && isRock(personalPlay)) ||
                (isPaper(opponentsPlay) && isPaper(personalPlay)) ||
                (isScissors(opponentsPlay) && isScissors(personalPlay));
    }

    private static boolean isRock(String play) {
        return play.equals("A") || play.equals("X");
    }

    private static boolean isPaper(String play) {
        return play.equals("B") || play.equals("Y");
    }

    private static boolean isScissors(String play) {
        return play.equals("C") || play.equals("Z");
    }

    private static File getFileFrom(String fileName) {
        ClassLoader classLoader = FirstDecember.class.getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    private static boolean isTheEndOfFile(Scanner fileContent) {
        return !fileContent.hasNextLine();
    }

}
