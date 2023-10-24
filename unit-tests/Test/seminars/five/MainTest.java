package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

class MainTest {

    //    Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
//    максимальное число в этом списке.
//    Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
//    тест, который проверяет, что оба модуля работают вместе правильно
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

//    У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
//    получения информации о пользователе. Ваша задача - написать интеграционный тест, который
//    проверяет, что UserService и UserRepository работают вместе должным образом.

    @Test
    void integrationUserTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String result = userService.getUserName(5);

        assertThat(result).isEqualTo("User 5");
    }

//    У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и PaymentService.
//    Класс OrderService обрабатывает заказы и делает вызовы к PaymentService для обработки платежей.
//    Ваша задача - написать интеграционный тест, который проверяет,
//    что OrderService и PaymentService взаимодействуют корректно

    @Test
    void orderServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean check = orderService.placeOrder(Mockito.anyString(), 123.45);

        assertTrue(check);
    }
}

