package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    List<Integer> randomList;

    @BeforeEach
    void setUp() {
        randomList = Arrays.asList(2, 5, 9, 7, 6, 1);
    }

    //5.1.
    @Test
    void randomNumberTest() {
        RandomNumberModule randomNumber = new RandomNumberModule();

        randomList = randomNumber.getList(6);

        assertThat(randomList.size()).isEqualTo(6);
    }

    //5.2.
    @Test
    void maxNumberModuleTest() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        int maxValue = maxNumberModule.getMaxValue(randomList);

        assertThat(maxValue).isEqualTo(9);
    }

    //5.3.
    @Test
    void maxRandomTest() {
        RandomNumberModule randomNumber = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        randomList = randomNumber.getList(6);
        int maxValue = maxNumberModule.getMaxValue(randomList);

        assertThat(Collections.max(randomList)).isEqualTo(maxValue);
    }
}