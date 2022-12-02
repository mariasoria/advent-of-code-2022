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
        int rockPoints = 1;
        int paperPoints = 2;
        int scissorsPoints = 3;

        if (havePlayedTheSame(opponentsPlay, personalPlay)) {
            return calculateDrawScore(personalPlay);
        }
        if (isRock(opponentsPlay)) {
            if (isPaper(personalPlay)) {
                return winScore + paperPoints;
            } else {
                return lostScore + scissorsPoints;
            }
        }
        if (isPaper(opponentsPlay)) {
            if (isRock(personalPlay)) {
                return lostScore + rockPoints;
            } else {
                return winScore + scissorsPoints;
            }
        }
        if (isScissors(opponentsPlay) && isRock(personalPlay)) {
            return winScore + rockPoints;
        }
        return lostScore + paperPoints;
    }

    private static Integer calculateDrawScore(String personalPlay) {
        int rockPoints = 1;
        int paperPoints = 2;
        int scissorsPoints = 3;
        int drawScore = 3;

        if (isRock(personalPlay)) {
            return drawScore + rockPoints;
        }
        if (isPaper(personalPlay)) {
            return drawScore + paperPoints;
        } else {
            return drawScore + scissorsPoints;
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
