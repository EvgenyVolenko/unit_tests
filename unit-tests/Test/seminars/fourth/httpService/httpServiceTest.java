package seminars.fourth.httpService;

import org.junit.jupiter.api.Test;
import seminars.fourth.webService.HttpClient;
import seminars.fourth.webService.WebService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class httpServiceTest {
    @Test
    void webServiceTest(){
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.getInfo(anyString())).thenReturn("Я вернул другую инфу!!!");
        String url = "pam.com";
        webService.getHttp(anyString());

        verify(httpClient, times(1)).getInfo(anyString());
    }
}