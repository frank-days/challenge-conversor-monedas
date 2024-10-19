import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedas {

    Conversion convertir( String base, String target, double amount ) {
        Conversion resultado = null;
        String API_KEY = "3f158d9e926ba50176833b6c";

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                + API_KEY
                + "/pair/"
                + base + "/" + target + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(
                    response.body(),
                    Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Conversion could not be completed");
        }

    }
}
