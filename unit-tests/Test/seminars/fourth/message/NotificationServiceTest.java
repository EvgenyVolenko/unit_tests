package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void messageSirviceTest() {
        String message = "Привет";
        String recipient = "Вася";
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);
        messageService.sendMessage(message, recipient);

        verify(messageService, times(1)).sendMessage(message, recipient);
    }
}