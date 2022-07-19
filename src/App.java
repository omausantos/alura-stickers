import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/k_jo2fa44w";
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        String body = client.send(request, BodyHandlers.ofString()).body();

        System.out.println(body);


    }
}
