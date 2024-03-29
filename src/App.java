import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        String body = client.send(request, BodyHandlers.ofString()).body();

        JasonParser parser = new JasonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());

        for (Map<String,String> filme : listaDeFilmes) {
            String titulo = filme.get("title");
            System.out.println("\u001b[0mTitulo: \u001b[1m" + titulo);
            String poster = filme.get("image");
            System.out.println("\u001b[0mPoster: \u001b[1m" + poster);
            String classificacao = filme.get("imDbRating");
            System.out.println("\u001b[37m\u001b[44mClassificação: " + classificacao + "\u001b[m");
            for(int item = 1; item <= Double.valueOf(classificacao); item++){
                System.out.print("\u2B50");
            }
            System.out.println();
            System.out.println();
        }
    }
}
