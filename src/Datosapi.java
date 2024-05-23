import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Datosapi {
    public String hacerConversion(String monedaPrimera, String monedaSegunda, double cantidad) {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c9a9aade0d33a9fd2a2014b6/pair/" +
                    monedaPrimera+ "/" + monedaSegunda + "/" + cantidad);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.get("conversion_result").getAsString();



        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Hubo un error Hay que solucionarlo ");
            throw new RuntimeException("Error" + e.getMessage());
        }
    }
}
