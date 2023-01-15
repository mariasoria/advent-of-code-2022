package codingiscaring.seconddecember;

import com.codingiscaring.seconddecember.SecondDecember;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondDecemberTest {
    @Test
    void should_calculate_the_score_from_puzzle_samples() throws FileNotFoundException {
        assertEquals(13526, SecondDecember.playRockPaperScissors("advent_calendar_day_2.txt"));
    }

    @Test
    void should_calculate_the_score_from_example_file() throws FileNotFoundException {
        assertEquals(14204, SecondDecember.playRockPaperScissorsWithExpectedResult("advent_calendar_day_2.txt"));
    }

}
