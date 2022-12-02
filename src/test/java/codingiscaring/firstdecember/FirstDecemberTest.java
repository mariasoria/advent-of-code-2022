package codingiscaring.firstdecember;

import com.codingiscaring.firstdecember.FirstDecember;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstDecemberTest {

    @Test
    void should_get_most_calories_from_puzzle_samples() throws FileNotFoundException {
        assertEquals(68292, FirstDecember.countMostCalories("advent_calendar_day_1.txt"));
    }

    @Test
    void should_count_the_top_three_most_calories_from_puzzle_samples() throws FileNotFoundException {
        assertEquals(203203, FirstDecember.countTopThreeMostCalories("advent_calendar_day_1.txt"));
    }
}
