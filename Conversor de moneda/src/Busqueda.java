import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busqueda {
    double conversion;

    public Conversion buscarConversion(String base_code, String target_code, double monto) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c76d3d9e732a4da9c8e4edde/pair/" + base_code + "/" + target_code + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void muestraResultado(String base_code, String target_code, double monto) {
        Busqueda miBusqueda = new Busqueda();
        conversion = miBusqueda.buscarConversion(base_code, target_code, monto).conversion_result();
        System.out.println("El valor " + monto + " [" + base_code + "] " + "corresponde al valor final de =>>> " + conversion + " [" + target_code + "]\n");
    }
}
