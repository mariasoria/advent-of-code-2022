package com.codingiscaring.seconddecember;

import com.codingiscaring.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecondDecember {

    private static String rock = "A";
    private static String paper = "B";
    private static String scissors = "C";

    public static Integer playRockPaperScissors(String fileName) throws FileNotFoundException {
        File file = FileUtils.getFileFrom(fileName);
        int score = 0;

        Scanner fileContent = new Scanner(file);
        while (FileUtils.isNotTheEndOfFile(fileContent)) {
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
        return play.equals(rock) || play.equals("X");
    }

    private static boolean isPaper(String play) {
        return play.equals(paper) || play.equals("Y");
    }

    private static boolean isScissors(String play) {
        return play.equals(scissors) || play.equals("Z");
    }

    public static int playRockPaperScissorsWithExpectedResult(String fileName) throws FileNotFoundException {
        File file = FileUtils.getFileFrom(fileName);
        int score = 0;

        Scanner fileContent = new Scanner(file);
        while (FileUtils.isNotTheEndOfFile(fileContent)) {
            String nextLine = fileContent.nextLine();
            String opponentsPlay = nextLine.split(" ")[0];
            String expectedResult = nextLine.split(" ")[1];
            score += calculateTotalScore(opponentsPlay, expectedResult);
        }
        return score;
    }

    private static int calculateTotalScore(String opponentsPlay, String expectedResult) {
        int points = 0;

        String personalPlay = "";
        if (shouldBeADraw(expectedResult)) {
            personalPlay = opponentsPlay;
            points += 3;
        }
        if (shouldLose(expectedResult)) {
            personalPlay = returnALosingPlay(opponentsPlay);
        }
        if (shouldWin(expectedResult)) {
            personalPlay = returnAWinningPlay(opponentsPlay);
            points += 6;
        }

        return calculatePersonalScore(points, personalPlay);
    }

    private static int calculatePersonalScore(int points, String personalPlay) {
        if(isPaper(personalPlay)) {
            points += 2;
        }
        if(isRock(personalPlay)) {
            points += 1;
        }
        if(isScissors(personalPlay)) {
            points += 3;
        }
        return points;
    }

    private static String returnALosingPlay(String opponentsPlay) {
        if (isRock(opponentsPlay)) {
            return scissors;
        }
        if (isPaper(opponentsPlay)) {
            return rock;
        }
        return paper;
    }

    private static String returnAWinningPlay(String opponentsPlay) {
        if (isRock(opponentsPlay)) {
            return paper;
        }
        if (isPaper(opponentsPlay)) {
            return scissors;
        }
        return rock;
    }

    private static boolean shouldLose(String play) {
        return play.equals("X");
    }

    private static boolean shouldBeADraw(String play) {
        return play.equals("Y");
    }

    private static boolean shouldWin(String play) {
        return play.equals("Z");
    }

}
