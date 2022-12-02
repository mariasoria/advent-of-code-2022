package codingiscaring.seconddecember;

import com.codingiscaring.seconddecember.SecondDecember;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondDecemberTest {
    @Test
    void should_get_most_calories_from_puzzle_samples() throws FileNotFoundException {
        assertEquals(13526, SecondDecember.playRockPaperScissors("advent_calendar_day_2.txt"));
    }

}
