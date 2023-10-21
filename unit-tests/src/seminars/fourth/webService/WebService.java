package seminars.fourth.webService;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void getHttp(String url) {
        System.out.println(httpClient.getInfo(url));
    }
}
