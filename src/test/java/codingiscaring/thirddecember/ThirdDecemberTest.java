package codingiscaring.thirddecember;

import com.codingiscaring.thirddecember.ThirdDecember;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThirdDecemberTest {

    @Test
    void should_calculate_the_sum_of_priorities_from_puzzle_file() throws FileNotFoundException {
        assertEquals(8105, ThirdDecember.findSumPriorities("advent_calendar_day_3.txt"));
    }

    @Test
    void should_find_duplicated_char() {
        assertEquals('p', ThirdDecember.findRucksackPriorityItem("vJrwpWtwJgWrhcsFMMfFFhFp"));
    }

    @Test
    void should_calculate_the_sum_of_group_priorities_from_puzzle_file() throws FileNotFoundException {
        assertEquals(2363, ThirdDecember.findSumPrioritiesByGroups("advent_calendar_day_3.txt"));
    }
}
