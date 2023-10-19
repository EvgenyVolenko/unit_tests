package seminars.third.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.coverage.SomeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 16, 44, 56})
    void divisionBy2WithoutRemainderPositive(int input) {
        boolean even = mainHW.evenOddNumber(input);
        assertTrue(even);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 111, 123, 1001})
    void divisionBy2WithoutRemainderNegative(int input) {
        boolean even = mainHW.evenOddNumber(input);
        assertFalse(even);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 72, 89})
    void numberFallsWithinRangePositive(int input){
        boolean numRange = mainHW.numberInInterval(input);
        assertTrue(numRange);
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 13, -5})
    void numberFallsWithinRangeNegative(int input){
        boolean numRange = mainHW.numberInInterval(input);
        assertFalse(numRange);
    }

    @Test
    void numberFallsWithinRangeLowerBound(){
        boolean numRange = mainHW.numberInInterval(25);
        assertFalse(numRange);
    }

    @Test
    void numberFallsWithinRangeUpperBound(){
        boolean numRange = mainHW.numberInInterval(100);
        assertFalse(numRange);
    }
}
